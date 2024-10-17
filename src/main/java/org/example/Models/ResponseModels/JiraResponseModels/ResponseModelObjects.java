package org.example.Models.ResponseModels.JiraResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ResponseModelObjects {

    private String self;
    private int votes;
    private boolean hasVoted;

    @Getter
    @Setter
    public static class Votes {
        private String self;
        private int votes;
        private boolean hasVoted;
    }

    @Getter
    @Setter
    public static class Watches {
        private String self;
        private int watchCount;
        private boolean isWatching;
    }

    @Getter
    @Setter
    public static class Worklog {
        private int startAt;
        private int maxResults;
        private int total;
        private ArrayList<Object> worklogs;
        private String self;
        private Author author;
        private UpdateAuthor updateAuthor;
        private Comment comment;
        private Date updated;
        private Visibility visibility;
        private Date started;
        private String timeSpent;
        private int timeSpentSeconds;
        private String id;
        private String issueId;
    }

    @Getter
    @Setter
    public static class Status {
        private String self;
        private String description;
        private String iconUrl;
        private String name;
        private String id;
        private StatusCategory statusCategory;
    }

    @Getter
    @Setter
    public static class StatusCategory {
        private String self;
        private int id;
        private String key;
        private String colorName;
        private String name;
    }

    @Getter
    @Setter
    public static class NonEditableReason {
        private String reason;
        private String message;
    }

    @Getter
    @Setter
    public static class Priority {
        private String self;
        private String iconUrl;
        private String name;
        private String id;
    }

    @Getter
    @Setter
    public static class Issuetype {
        private String self;
        private String id;
        private String description;
        private String iconUrl;
        private String name;
        private boolean subtask;
        private int avatarId;
        private int hierarchyLevel;
    }

    @Getter
    @Setter
    public static class Mark {
        private String type;
    }

    @Getter
    @Setter
    public static class Reporter {
        private String self;
        private String accountId;
        private String emailAddress;
        private AvatarUrls avatarUrls;
        private String displayName;
        private boolean active;
        private String timeZone;
        private String accountType;
    }

    @Getter
    @Setter
    public static class Customfield10018 {
        private boolean hasEpicLinkFieldDependency;
        private boolean showField;
        private NonEditableReason nonEditableReason;
    }

    @Getter
    @Setter
    public static class Creator {
        private String self;
        private String accountId;
        private String emailAddress;
        private AvatarUrls avatarUrls;
        private String displayName;
        private boolean active;
        private String timeZone;
        private String accountType;
    }

    @Getter
    @Setter
    public static class Aggregateprogress {
        private int progress;
        private int total;
    }

    @Getter
    @Setter
    public static class Attrs {
        private String id;
        private String type;
        private String collection;
        private int width;
        private int height;
        private String url;
        private String layout;
    }

    @Getter
    @Setter
    public static class AvatarUrls {
        @JsonProperty("48x48")
        public String _48x48;
        @JsonProperty("24x24")
        public String _24x24;
        @JsonProperty("16x16")
        public String _16x16;
        @JsonProperty("32x32")
        public String _32x32;
    }

    @Getter
    @Setter
    public static class Attachment {
        private String self;
        private String id;
        private String filename;
        private Author author;
        private Date created;
        private int size;
        private String mimeType;
        private String content;
        private String thumbnail;
    }

    @Getter
    @Setter
    public static class Author {
        private String self;
        private String key;
        private String accountId;
        private String accountType;
        private String name;
        private AvatarUrls avatarUrls;
        private String displayName;
        private boolean active;
        private String emailAddress;
        private String timeZone;
    }

    @Getter
    @Setter
    public static class Body {
        private String type;
        private int version;
        private List<Content> content;
    }

    @Getter
    @Setter
    public static class Comment {
        private String self;
        private String id;
        private Author author;
        private Body body;
        private UpdateAuthor updateAuthor;
        private Date created;
        private Date updated;
        private Visibility visibility;
        private String type;
        private int version;
        private ArrayList<Content> content;
        private String renderedBody;
        private boolean jsdPublic;
        private ArrayList<Object> comments;
        private int maxResults;
        private int total;
        private int startAt;
    }

    @Getter
    @Setter
    public static class Content {
        private String type;
        private ArrayList<Content> content;
        private String text;
        private Attrs attrs;
        private ArrayList<Mark> marks;
    }

    @Getter
    @Setter
    public static class Description {
        private String type;
        private int version;
        private ArrayList<Content> content;
    }

    @Getter
    @Setter
    public static class Fields {
        public Date statuscategorychangedate;
        public ArrayList<Object> fixVersions;
        public Object resolution;
        public Object lastViewed;
        public Object customfield_10062;
        public Object customfield_10063;
        public Priority priority;
        public ArrayList<Object> labels;
        public Object timeestimate;
        public Object aggregatetimeoriginalestimate;
        public ArrayList<Object> versions;
        public ArrayList<Object> issuelinks;
        public Object assignee;
        public Status status;
        public ArrayList<Object> components;
        public Object customfield_10050;
        public Object customfield_10051;
        public Object customfield_10052;
        public Object customfield_10053;
        public Object customfield_10054;
        public Object customfield_10055;
        public Object customfield_10056;
        public Object customfield_10057;
        public Object customfield_10058;
        public Object customfield_10049;
        public Object aggregatetimeestimate;
        public Creator creator;
        public ArrayList<Object> subtasks;
        public Object customfield_10040;
        public Object customfield_10041;
        public Object customfield_10042;
        public ArrayList<Object> customfield_10043;
        public Reporter reporter;
        public Object customfield_10044;
        public Aggregateprogress aggregateprogress;
        public Object customfield_10045;
        public Object customfield_10046;
        public Object customfield_10047;
        public Object customfield_10048;
        public Object customfield_10038;
        public Object customfield_10039;
        public Progress progress;
        public Votes votes;
        public Worklog worklog;
        public Issuetype issuetype;
        public Object timespent;
        public Object customfield_10030;
        public Object customfield_10031;
        public Project project;
        public Object customfield_10032;
        public Object customfield_10033;
        public Object aggregatetimespent;
        public ArrayList<Object> customfield_10034;
        public Object customfield_10035;
        public Object customfield_10036;
        public Object customfield_10037;
        public Object customfield_10027;
        public Object customfield_10028;
        public Object customfield_10029;
        public Object resolutiondate;
        public int workratio;
        public Watches watches;
        public Date created;
        public Object customfield_10020;
        public Object customfield_10021;
        public Object customfield_10022;
        public Object customfield_10023;
        public Object customfield_10024;
        public Object customfield_10025;
        public Object customfield_10026;
        public Object customfield_10016;
        public Object customfield_10017;
        public Customfield10018 customfield_10018;
        public String customfield_10019;
        public Date updated;
        public Object timeoriginalestimate;
        public Description description;
        public Object customfield_10010;
        public Object customfield_10014;
        public Timetracking timetracking;
        public Object customfield_10015;
        public Object customfield_10005;
        public Object customfield_10006;
        public Object security;
        public Object customfield_10007;
        public Object customfield_10008;
        public ArrayList<Attachment> attachment;
        public Object customfield_10009;
        public String summary;
        public Object customfield_10001;
        public ArrayList<Object> customfield_10002;
        public Object customfield_10003;
        public Object customfield_10004;
        public Object environment;
        public Object duedate;
        public Comment comment;
    }

    @Getter
    @Setter
    public static class Issue {
        private String expand;
        private String id;
        private String self;
        private String key;
        private RenderedFields renderedFields;
        private Fields fields;
    }

    @Getter
    @Setter
    public static class Project {
        private String self;
        private String id;
        private String key;
        private String name;
        private AvatarUrls avatarUrls;
        private ProjectCategory projectCategory;
        private String projectTypeKey;
        private boolean simplified;
    }

    @Getter
    @Setter
    public static class ProjectCategory {
        private String self;
        private String id;
        private String name;
        private String description;
    }

    @Getter
    @Setter
    public static class Progress {
        private int progress;
        private int total;
    }

    @Getter
    @Setter
    public static class RenderedFields {
        private String statuscategorychangedate;
        private Object issuetype;
        private Object timespent;
        private Object customfield10030;
        private Object project;
        private Object customfield10031;
        private Object customfield10032;
        private Object fixVersions;
        private Object aggregatetimespent;
        private Object customfield10034;
        private Object customfield10035;
        private Object resolution;
        private Object customfield10036;
        private Object customfield10037;
        private Object customfield10029;
        private Object resolutiondate;
        private Object workratio;
        private String lastViewed;
        private Object watches;
        private String created;
        private Object customfield10020;
        private Object customfield10021;
        private Object customfield10022;
        private Object priority;
        private Object customfield10023;
        private Object customfield10024;
        private Object customfield10025;
        private Object labels;
        private Object customfield10016;
        private String customfield10017;
        private Object customfield10018;
        private Object customfield10019;
        private Object aggregatetimeoriginalestimate;
        private Object timeestimate;
        private Object versions;
        private Object issuelinks;
        private Object assignee;
        private String updated;
        private Object status;
        private Object components;
        private Object timeoriginalestimate;
        private Object description;
        private Object customfield10010;
        private Object customfield10014;
        private Object customfield10015;
        private Object customfield10005;
        private Object customfield10006;
        private Object customfield10007;
        private Object security;
        private Object customfield10008;
        private Object aggregatetimeestimate;
        private Object customfield10009;
        private String summary;
        private Object creator;
        private Object subtasks;
        private Object reporter;
        private Object customfield10000;
        private Object aggregateprogress;
        private Object customfield10001;
        private Object customfield10002;
        private Object customfield10003;
        private Object customfield10004;
        private Object customfield10038;
        private Object environment;
        private Object duedate;
        private Object progress;
        private Object votes;
    }

    @Getter
    @Setter
    public static class SubTask {
        private String id;
        private String self;
        private String key;
        private Fields fields;
    }

    @Getter
    @Setter
    public static class Timetracking {
        private String timeSpent;
        private int timeSpentSeconds;
        private String timeRemaining;
        private int timeRemainingSeconds;
        private String originalEstimate;
        private int originalEstimateSeconds;
    }

    @Getter
    @Setter
    public static class UpdateAuthor {
        private String self;
        private String accountId;
        private String emailAddress;
        private AvatarUrls avatarUrls;
        private String displayName;
        private boolean active;
        private String timeZone;
        private String accountType;
    }

    @Getter
    @Setter
    public static class Visibility {
        private String type;
        private String value;
    }

    @Getter
    @Setter
    public static class Watcher {
        private String self;
        private int watchCount;
        private boolean isWatching;
    }
}
