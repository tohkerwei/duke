public class DukeException extends Exception {
    public DukeException(String error){
        super(error);
    }
    String err = error;
    String errorMessage = "";
    Switch (err) {
        case ("todo"):
            errorMessage = "";
            break;
        case ("deadline"):
            errorMessage = "";
            break;
        case ("event"):
            errorMessage = "";
            break;
        case ("default"):
            errorMessage = "";
            break;
    }

    @Override
    public String toString(){
        return errorMessage;
    }
}
