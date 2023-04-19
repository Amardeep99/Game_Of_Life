import javax.swing.JFrame;

public class Controller {
    private Model model;
    private View view;

    Controller(){
        model = new Model(this);
        view = new View(this);
    }
    
    
}
