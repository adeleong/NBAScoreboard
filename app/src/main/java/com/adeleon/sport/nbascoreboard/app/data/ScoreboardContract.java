package com.adeleon.sport.nbascoreboard.app.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by theade on 3/31/2015.
 */

/**
 * Defines table and column names for the weather database.
 */
public class ScoreboardContract {


    public static final String CONTENT_AUTHORITY = "com.adeleon.sport.nbascoreboard.app";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_EVENT = "event";
    public static final String PATH_TEAM = "team";


    /*
        Inner class that defines the contents of the TeamEntry table
     */
    public static final class TeamEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TEAM).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TEAM;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TEAM;

        public static final String TABLE_NAME = "team";
        public static final String COLUMN_TEAM_ID = "team_id";
        public static final String COLUMN_FIRST_NAME_TEAM = "first_name_team";
        public static final String COLUMN_LAST_NAME_TEAM = "last_name_team";
        public static final String COLUMN_ABBREVIATION = "abbreviation";
        public static final String COLUMN_SITE_NAME = "site_name";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_STATE = "state";

        /*public static Uri buildTeamUri(String teamId) {
               return ContentUris.withAppendedId(CONTENT_URI, teamId);
        }*/

    }

    public static final class EventEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_EVENT).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EVENT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EVENT;

        public static final String TABLE_NAME = "event";
        public static final String COLUMN_EVENT_ID = "event_id";
        public static final String COLUMN_START_DATE_TIME = "start_date_time";
        public static final String COLUMN_EVENT_STATUS = "event_status";
        public static final String COLUMN_AWAY_TEAM_ID_KEY = "away_team_id";
        public static final String COLUMN_HOME_TEAM_ID_KEY = "home_team_id";
        public static final String COLUMN_AWAY_PERIOD_FIRTS = "away_period_firts";
        public static final String COLUMN_AWAY_PERIOD_SECOND = "away_period_second";
        public static final String COLUMN_AWAY_PERIOD_THIRD = "away_period_third";
        public static final String COLUMN_AWAY_PERIOD_FOURTH = "away_period_fourth";
        public static final String COLUMN_HOME_PERIOD_FIRTS = "home_period_firts";
        public static final String COLUMN_HOME_PERIOD_SECOND = "home_period_second";
        public static final String COLUMN_HOME_PERIOD_THIRD = "home_period_third";
        public static final String COLUMN_HOME_PERIOD_FOURTH = "home_period_fourth";

        public static Uri buildEvetUri(String EventId) {
            return CONTENT_URI.buildUpon().appendPath(EventId).build();
        }

        /*
            Student: Fill in this buildWeatherLocation function
         */
        public static Uri buildEventTeam(String teamId) {
            return CONTENT_URI.buildUpon().appendPath(teamId).build();
        }

       /* public static Uri buildWeatherLocationWithStartDate(
                String locationSetting, long startDate) {
            long normalizedDate = normalizeDate(startDate);
            return CONTENT_URI.buildUpon().appendPath(locationSetting)
                    .appendQueryParameter(COLUMN_DATE, Long.toString(normalizedDate)).build();
        }*/

        public static Uri buildEventTeamWithStartDate(String teamId, String StartDate) {
            return CONTENT_URI.buildUpon().appendPath(teamId)
                    .appendPath(StartDate).build();
        }

        public static String getTeamSettingFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static long getDateFromUri(Uri uri) {
            return Long.parseLong(uri.getPathSegments().get(2));
        }

        public static String getStartDateFromUri(Uri uri) {
            String dateString = uri.getQueryParameter(COLUMN_START_DATE_TIME);
            /*if (null != dateString && dateString.length() > 0)
                return Long.parseLong(dateString);
            else*/
                return dateString;// 0;
        }
    }

    /* Inner class that defines the contents of the EventPlayer table */
    public static final class EventPlayerEntry implements BaseColumns {

        public static final String TABLE_NAME = "event_player";
        public static final String COLUMN_EVENT_PLAYER_ID = "event_player_id";
        public static final String COLUMN_EVENT_ID_KEY = "event_id";
        public static final String COLUMN_TEAM_ID_KEY = "team_id";
        public static final String COLUMN_FIRST_NAME = "first_name";
        public static final String COLUMN_LAST_NAME = "last_name";
        public static final String COLUMN_POSITION = "position";
        public static final String COLUMN_MINUTES = "minutes";
        public static final String COLUMN_POINTS = "points";
        public static final String COLUMN_ASSISTS = "assists";
        public static final String COLUMN_BLOCKS = "blocks";
        public static final String COLUMN_REBOUNDS = "rebounds";
    }
}