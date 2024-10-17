package org.example.Translators.CarrierDatabaseTranslators;

import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import org.example.ApiRoutes;
import org.example.Models.CommunicationModels.CarrierModels.Todo;
import org.example.Models.ResponseModels.Response;
import org.example.Translator;
import org.example.Translators.CarrierDatabaseTranslators.Interfaces.ITodoListSubTranslator;

import java.util.Collections;
import java.util.List;

public class TodoListSubTranslator extends Translator implements ITodoListSubTranslator {
    public TodoListSubTranslator(String token, Long auditUserId, Long carrierId) {
        super(token, auditUserId, carrierId);
    }

    @Override
    public Response<Long> addTodo(Todo todo) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.TODO + "/" + ApiRoutes.TodoSubRoute.ADD_ITEM),
                "PUT",
                new TypeToken<Response<Long>>(){}.getType(),
                todo);
    }

    @Override
    public Response<Boolean> deleteTodo(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.TODO + "/" + ApiRoutes.TodoSubRoute.DELETE_ITEM,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<Boolean> toggleTodo(long id) {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.TODO + "/" + ApiRoutes.TodoSubRoute.TOGGLE_DONE,
                        Collections.singletonMap("id", id)),
                "DELETE",
                new TypeToken<Response<Boolean>>(){}.getType(),
                null);
    }

    @Override
    public Response<List<Todo>> getItems() {
        return httpResponse(getApiUrl(ApiRoutes.ApiControllerNames.TODO + "/" + ApiRoutes.TodoSubRoute.GET_ITEMS),
                "GET",
                new TypeToken<Response<List<Todo>>>(){}.getType(),
                null);
    }
}