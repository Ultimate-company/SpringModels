package org.example.CommonHelpers;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.Adapters.DateAdapter;
import org.example.Adapters.LocalDateTimeAdapter;
import org.example.Models.ResponseModels.ApiResponseModels.GetAttachmentMetadataResponseModel;
import org.example.Models.ResponseModels.JiraResponseModels.*;
import org.example.Models.ResponseModels.Response;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class JiraHelper {
    private final String password;
    private final String projectUrl;
    private final String projectKey;
    private final String username;
    private final Gson gson;
    private final HttpClient client;

    public JiraHelper(String projectUrl, String username, String password, String projectKey) {
        this.projectUrl = projectUrl;
        this.username = username;
        this.password = password;
        this.projectKey = projectKey;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .registerTypeAdapter(Date.class, new DateAdapter())
                .create();
        this.client = HttpClient.newHttpClient();
    }

    /**
     * Deletes an issue type in Jira using the provided issue type name.
     *
     * @param jiraIssueTypeName issue type name
     * @return A response whether the issue type was susccessfully deleted.
     */

    public Response<Boolean> deleteIssueType(String jiraIssueTypeName) {
        Response<List<GetIssueTypesResponseModel>> getIssuesTypesResponse =  getIssueTypes();
        if(!getIssuesTypesResponse.isSuccess()) {
            return new Response<>(false, getIssuesTypesResponse.getMessage(), false);
        }

        Optional<String> jiraIssueTypeId = getIssuesTypesResponse.getItem().stream()
                .filter(issueType -> !issueType.getName().contains("[System]"))
                .filter(issueType -> issueType.getName().equals(jiraIssueTypeName))
                .map(GetIssueTypesResponseModel::getId)
                .findFirst();

        if(jiraIssueTypeId.isPresent()) {
            return sendRequest(String.format("/rest/api/3/issuetype/%s", jiraIssueTypeId.get()), "DELETE", null, Boolean.class);
        }
        else {
            return new Response<>(false, "No issue type found with given name to delete.", false);
        }
    }

    /**
     * Creates a new issue type in Jira using the provided JSON content.
     *
     * @param jsonContent The JSON content representing the new issue type.
     * @return A response containing the created issue type information.
     */
    public Response<CreateIssueTypeResponseModel> createIssueType(String jsonContent) {
        return sendRequest("/rest/api/3/issuetype", "POST", jsonContent, CreateIssueTypeResponseModel.class);
    }

    /**
     * Retrieves a list of issue types from the Jira API.
     *
     * @return A response containing a list of issue types.
     */
    public Response<List<GetIssueTypesResponseModel>> getIssueTypes() {
        return sendRequest("/rest/api/3/issuetype", "GET", null,
                new TypeToken<List<GetIssueTypesResponseModel>>() {}.getType());
    }

    /**
     * Retrieves a list of tickets from the Jira API based on the specified project key and range.
     *
     * @param start The starting index of the range of tickets to retrieve.
     * @param end The ending index of the range of tickets to retrieve.
     * @return A response containing the retrieved tickets.
     */
    public Response<GetTicketsResponseModel> getTickets(int start, int end) {
        return sendRequest(String.format("/rest/api/3/search?jql=project=%s&maxResults=%d&startAt=%d&expand=renderedFields",
                projectKey, end - start, start), "GET", null, GetTicketsResponseModel.class);
    }

    /**
     * Retrieves the comments associated with a specific ticket from the Jira API.
     *
     * @param ticketId The ID of the ticket for which to retrieve the comments.
     * @return A response containing the retrieved comments.
     */
    public Response<GetCommentsResponseModel> getComments(String ticketId) {
        return sendRequest(String.format("/rest/api/3/issue/%s/comment?expand=renderedBody", ticketId), "GET", null, GetCommentsResponseModel.class);
    }

    /**
     * Edits a Jira ticket using the provided JSON content and ticket ID.
     *
     * @param jsonContent The JSON content representing the changes to the ticket.
     * @param ticketId The ID of the ticket to edit.
     * @return A response indicating the success or failure of the operation.
     */
    public Response<Boolean> editTicket(String ticketId, String jsonContent) {
        return sendRequest(String.format("/rest/api/3/issue/%s", ticketId), "PUT", jsonContent, Boolean.class);
    }

    /**
     * Creates a new Jira ticket using the provided JSON content.
     *
     * @param jsonContent The JSON content representing the new ticket.
     * @return A response containing the created ticket information.
     */
    public Response<CreateTicketResponseModel> createTicket(String jsonContent) {
        return sendRequest("/rest/api/3/issue", "POST", jsonContent, CreateTicketResponseModel.class);
    }

    /**
     * Deletes an existing Jira ticket using the provided ticket ID.
     *
     * @param ticketId The ID of the ticket to be deleted.
     * @return A response indicating the success or failure of the delete operation.
     */
    public Response<Boolean> deleteTicket(String ticketId) {
        return sendRequest("/rest/api/3/issue/" + ticketId, "DELETE", null, Boolean.class);
    }

    /**
     * Deletes an existing comment using the provided ticket ID and comment ID.
     *
     * @param ticketId The ID of the ticket to be deleted.
     * @param commentId The ID of the ticket to be deleted.
     * @return A response indicating the success or failure of the delete operation.
     */
    public Response<Boolean> deleteComment(String ticketId, String commentId) {
        return sendRequest("/rest/api/3/issue/" + ticketId + "/comment/" + commentId, "DELETE", null, Boolean.class);
    }

    /**
     * Retrieves the content of an attachment from the Jira API.
     *
     * @param attachmentId The ID of the attachment to retrieve.
     * @return The content of the attachment as a byte array.
     */
    public Response<String> getAttachment(String attachmentId) {
        try {
            HttpRequest request = createRequest("/rest/api/3/attachment/content/" + attachmentId, "GET", null);

            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

            if (response.statusCode() == 303) {
                return new Response<>(true, "Successfully fetched attachment download url", response.headers().firstValue("location").orElse(null));
            }

            return new Response<>(false, "Error fetching the attachment.", null);
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }

    /**
     * Retrieves the content of an attachment metadata from the Jira API.
     *
     * @param attachmentId The ID of the attachment to retrieve.
     * @return The content of the attachment metadata
     */
    public Response<GetAttachmentMetadataResponseModel> getAttachmentMetadata(String attachmentId) {
        return sendRequest("/rest/api/3/attachment/" + attachmentId, "GET", null, GetAttachmentMetadataResponseModel.class);
    }

    /**
     * Adds attachments to a ticket in Jira.
     *
     * @param ticketId The ID of the ticket to add attachments to.
     * @param attachments A map containing the file names and file contents of the attachments.
     * @return A Response object containing a list of CreateAttachmentResponse objects if successful, or an error message if not.
     */
    public Response<List<CreateAttachmentResponseModel>> addAttachment(String ticketId, Map<String, byte[]> attachments) {
        try {
            String boundary = "----WebKitFormBoundary" + UUID.randomUUID();

            // Create multipart body
            StringBuilder multipartBody = new StringBuilder();
            for (Map.Entry<String, byte[]> entry : attachments.entrySet()) {
                String fileName = entry.getKey();
                byte[] fileContent = entry.getValue();

                // Add file part
                multipartBody.append("--").append(boundary).append("\r\n");
                multipartBody.append("Content-Disposition: form-data; name=\"file\"; filename=\"").append(fileName).append("\"\r\n");
                multipartBody.append("Content-Type: application/octet-stream\r\n\r\n");
                multipartBody.append(new String(fileContent, StandardCharsets.ISO_8859_1)).append("\r\n");
            }
            multipartBody.append("--").append(boundary).append("--\r\n");

            // Create the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(projectUrl + "/rest/api/3/issue/" + ticketId + "/attachments"))
                    .header("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.US_ASCII)))
                    .header("Accept", "application/json")
                    .header("X-Atlassian-Token", "no-check")
                    .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                    .POST(HttpRequest.BodyPublishers.ofString(multipartBody.toString(), StandardCharsets.ISO_8859_1))
                    .build();

            // Send the request and deserialize
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                return new Response<>(false, "Error in adding attachments.", null);
            }

            List<CreateAttachmentResponseModel> createAttachmentResponseModels = gson.fromJson(response.body(), new TypeToken<List<CreateAttachmentResponseModel>>() {}.getType());
            return new Response<>(true, "", createAttachmentResponseModels);
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }

    /**
     * Adds a comment to a ticket in Jira.
     *
     * @param ticketId The ID of the ticket to add the comment to.
     * @param jsonContent The JSON content of the comment.
     * @return A Response object containing a CreateCommentResponse object if successful, or an error message if not.
     */
    public Response<AddCommentResponseModel> addComment(String ticketId, String jsonContent) {
        String jsonBody = "{ \"body\" : " + jsonContent + " }";
        return sendRequest("/rest/api/3/issue/" + ticketId + "/comment", "POST", jsonBody, AddCommentResponseModel.class);
    }

    /**
     * edits a comment to a ticket in Jira.
     *
     * @param ticketId The ID of the ticket to add the comment to.
     * @param jsonContent The JSON content of the comment.
     * @return A boolean response object indiciating the edit comment operation
     */
    public Response<Boolean> editComment(String ticketId, String commentId, String jsonContent) {
        String jsonBody = "{ \"body\" : " + jsonContent + " }";

        Response<Boolean> editCommentResponse = sendRequest("/rest/api/3/issue/" + ticketId + "/comment/" + commentId, "PUT", jsonBody, AddCommentResponseModel.class);
        if(!editCommentResponse.isSuccess()) {
            return new Response<>(false, editCommentResponse.getMessage(), false);
        }

        return new Response<>(true, editCommentResponse.getMessage(), true);
    }

    /**
     * Retrieves the details of a ticket from the Jira API.
     *
     * @param ticketId The ID of the ticket to retrieve.
     * @return A response object containing the ticket details.
     */
    public Response<GetTicketDetailsResponseModel> getTicketDetails(String ticketId) {
        return sendRequest("/rest/api/3/issue/" + ticketId + "?expand=renderedFields,rend", "GET", null, GetTicketDetailsResponseModel.class);
    }

    private <T> Response<T> sendRequest(String endpoint, String method, Object body, Type responseType) {
        try {
            HttpRequest request = createRequest(endpoint, method, body);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            switch (method){
                case "PUT":
                    if(response.statusCode() == 204) {
                        if(responseType == Boolean.class) {
                            return new Response<>(true, "Successfully processed request", null);
                        }
                        else {
                            T responseObject = gson.fromJson(response.body(), responseType);
                            return new Response<>(true, "Successfully processed request", responseObject);
                        }
                    }
                    else if(response.statusCode() == 200) {
                        T responseObject = gson.fromJson(response.body(), responseType);
                        return new Response<>(true, "Successfully processed request", responseObject);
                    }
                    else {
                        return new Response<>(false, "Error in API call", null);
                    }
                case "DELETE":
                    if(response.statusCode() == 204) {
                        return new Response<>(true, "Successfully processed request", null);
                    }
                    else {
                        return new Response<>(false, "Error in API call", null);
                    }
                case "POST":
                    if(response.statusCode() == 201) {
                        T responseObject = gson.fromJson(response.body(), responseType);
                        return new Response<>(true, "Successfully processed request", responseObject);
                    }
                    else {
                        return new Response<>(false, "Error in API call", null);
                    }
                default:
                    if(response.statusCode() == 200) {
                        T responseObject = gson.fromJson(response.body(), responseType);
                        return new Response<>(true, "Successfully processed request", responseObject);
                    }
                    else {
                        return new Response<>(false, "Error in API call", null);
                    }
            }
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }

    private HttpRequest createRequest(String endpoint, String method, Object body) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(projectUrl + endpoint))
                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.US_ASCII)))
                .header("Content-Type", "application/json");

        if (body != null) {
            switch (method) {
                case "POST":
                    requestBuilder.POST(body instanceof InputStream ? HttpRequest.BodyPublishers.ofInputStream(() -> (InputStream) body) : HttpRequest.BodyPublishers.ofString((String) body));
                    break;
                case "PUT":
                    requestBuilder.PUT(HttpRequest.BodyPublishers.ofString((String) body));
                    break;
                case "GET":
                    requestBuilder.GET();
                    break;
                case "DELETE":
                    requestBuilder.DELETE();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported method: " + method);
            }
        } else {
            requestBuilder.method(method, HttpRequest.BodyPublishers.noBody());
        }

        return requestBuilder.build();
    }
}