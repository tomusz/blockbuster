public class ConsoleMsg {

    private static final String PROVIDE_TWO_DATES = "Please provide year range for films\nExample 1900 2020";
    private static final String PROVIDE_FIRST_AND_LAST_NAME =
            "Please provide first and last name of actor\nExample Michelle Yeoh";
    private static final String MENU_WELCOME = "Welcome In Movie Library!\nLet's find you a movie!";
    private static final String MENU_TWO_DATES = "1. Find movies in time range";
    private static final String MENU_DISPLAY_RANDOM_MOVIE_DETAILS = "2. Display random movie details";
    private static final String MENU_ACTOR_FIRST_LAST_NAME = "3. Find movies with provided actor";
    private static final String MENU_EXIT = "4. Exit. Library is saved on exit to new file";
    private static final String MENU_WRONG_OPTION = "Wrong option selected please try again";
    private static final String NO_RESULTS_FOR_PROVIDED_CRITERIA = "No results for provided criteria";

    public static String getProvideTwoDates() {
        return PROVIDE_TWO_DATES;
    }

    public static String getProvideFirstAndLastName() {
        return PROVIDE_FIRST_AND_LAST_NAME;
    }

    public static String getApplicationMenu() {
        return MENU_WELCOME + "\n" +
                MENU_TWO_DATES + "\n" +
                MENU_DISPLAY_RANDOM_MOVIE_DETAILS + "\n" +
                MENU_ACTOR_FIRST_LAST_NAME + "\n" +
                MENU_EXIT;
    }

    public static String getMenuWrongOption() {
        return MENU_WRONG_OPTION;
    }

    public static String getNoResultsForProvidedCriteria() {
        return NO_RESULTS_FOR_PROVIDED_CRITERIA;
    }
}