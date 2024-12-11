package org.example.Constants;

import java.util.TreeMap;

public class SchedulerEventTypes {
    public static class WorkRelatedEvents {
        public static final String MEETING = "Meeting";
        public static final String CONFERENCE = "Conference";
        public static final String WEBINAR = "Webinar";
        public static final String WORKSHOP = "Workshop";
        public static final String TEAM_BUILDING_ACTIVITY = "Team Building Activity";
        public static final String TRAINING_SESSION = "Training Session";
        public static final String PERFORMANCE_REVIEW = "Performance Review";
        public static final String PROJECT_DEADLINE = "Project Deadline";
        public static final String BRAINSTORMING_SESSION = "Brainstorming Session";
        public static final String CLIENT_CALL = "Client Call";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(MEETING, "Meeting");
            LABEL_MAP.put(CONFERENCE, "Conference");
            LABEL_MAP.put(WEBINAR, "Webinar");
            LABEL_MAP.put(WORKSHOP, "Workshop");
            LABEL_MAP.put(TEAM_BUILDING_ACTIVITY, "Team Building Activity");
            LABEL_MAP.put(TRAINING_SESSION, "Training Session");
            LABEL_MAP.put(PERFORMANCE_REVIEW, "Performance Review");
            LABEL_MAP.put(PROJECT_DEADLINE, "Project Deadline");
            LABEL_MAP.put(BRAINSTORMING_SESSION, "Brainstorming Session");
            LABEL_MAP.put(CLIENT_CALL, "Client Call");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class PersonalEvents {
        public static final String BIRTHDAY = "Birthday";
        public static final String ANNIVERSARY = "Anniversary";
        public static final String PERSONAL_TASK = "Personal Task";
        public static final String FAMILY_GATHERING = "Family Gathering";
        public static final String VACATION = "Vacation";
        public static final String HEALTH_APPOINTMENT = "Health Appointment";
        public static final String WORKOUT_SESSION = "Workout Session";
        public static final String STUDY_TIME = "Study Time";
        public static final String MEDITATION = "Meditation";
        public static final String SHOPPING = "Shopping";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(BIRTHDAY, "Birthday");
            LABEL_MAP.put(ANNIVERSARY, "Anniversary");
            LABEL_MAP.put(PERSONAL_TASK, "Personal Task");
            LABEL_MAP.put(FAMILY_GATHERING, "Family Gathering");
            LABEL_MAP.put(VACATION, "Vacation");
            LABEL_MAP.put(HEALTH_APPOINTMENT, "Health Appointment");
            LABEL_MAP.put(WORKOUT_SESSION, "Workout Session");
            LABEL_MAP.put(STUDY_TIME, "Study Time");
            LABEL_MAP.put(MEDITATION, "Meditation");
            LABEL_MAP.put(SHOPPING, "Shopping");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class SocialEvents {
        public static final String NETWORKING_EVENT = "Networking Event";
        public static final String DINNER_PARTY = "Dinner Party";
        public static final String COMMUNITY_EVENT = "Community Event";
        public static final String CHARITY_EVENT = "Charity Event";
        public static final String CONCERT = "Concert";
        public static final String FESTIVAL = "Festival";
        public static final String SPORTS_MATCH = "Sports Match";
        public static final String MOVIE_NIGHT = "Movie Night";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(NETWORKING_EVENT, "Networking Event");
            LABEL_MAP.put(DINNER_PARTY, "Dinner Party");
            LABEL_MAP.put(COMMUNITY_EVENT, "Community Event");
            LABEL_MAP.put(CHARITY_EVENT, "Charity Event");
            LABEL_MAP.put(CONCERT, "Concert");
            LABEL_MAP.put(FESTIVAL, "Festival");
            LABEL_MAP.put(SPORTS_MATCH, "Sports Match");
            LABEL_MAP.put(MOVIE_NIGHT, "Movie Night");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class EducationalEvents {
        public static final String LECTURE = "Lecture";
        public static final String ONLINE_COURSE = "Online Course";
        public static final String EXAM_DATE = "Exam Date";
        public static final String WORKSHOP = "Workshop";
        public static final String CLASS_SESSION = "Class/Session";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(LECTURE, "Lecture");
            LABEL_MAP.put(ONLINE_COURSE, "Online Course");
            LABEL_MAP.put(EXAM_DATE, "Exam Date");
            LABEL_MAP.put(WORKSHOP, "Workshop");
            LABEL_MAP.put(CLASS_SESSION, "Class/Session");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class SpecialOccasions {
        public static final String HOLIDAY = "Holiday";
        public static final String CULTURAL_CELEBRATION = "Cultural Celebration";
        public static final String RELIGIOUS_EVENT = "Religious Event";
        public static final String WEDDING = "Wedding";
        public static final String BABY_SHOWER = "Baby Shower";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(HOLIDAY, "Holiday");
            LABEL_MAP.put(CULTURAL_CELEBRATION, "Cultural Celebration");
            LABEL_MAP.put(RELIGIOUS_EVENT, "Religious Event");
            LABEL_MAP.put(WEDDING, "Wedding");
            LABEL_MAP.put(BABY_SHOWER, "Baby Shower");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }

    public static class MiscellaneousEvents {
        public static final String REMINDER = "Reminder";
        public static final String DEADLINE = "Deadline";
        public static final String FOLLOW_UP = "Follow-Up";
        public static final String LAUNCH_EVENT = "Launch Event";
        public static final String TASK_REVIEW = "Task Review";

        private static final TreeMap<String, String> LABEL_MAP = new TreeMap<>();

        static {
            LABEL_MAP.put(REMINDER, "Reminder");
            LABEL_MAP.put(DEADLINE, "Deadline");
            LABEL_MAP.put(FOLLOW_UP, "Follow-Up");
            LABEL_MAP.put(LAUNCH_EVENT, "Launch Event");
            LABEL_MAP.put(TASK_REVIEW, "Task Review");
        }

        public static TreeMap<String, String> getLabels() {
            return LABEL_MAP;
        }
    }
}
