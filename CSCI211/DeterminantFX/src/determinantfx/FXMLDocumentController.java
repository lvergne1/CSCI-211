
package determinantfx;

 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
 

//Controller class 
public class FXMLDocumentController{
    
    @FXML private Text actiontarget;
    @FXML private TextField A,B,C,D;
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        int a = Integer.parseInt(A.getText());
        int b = Integer.parseInt(B.getText());
        int c = Integer.parseInt(C.getText());
        int d = Integer.parseInt(D.getText());
        
        int determinant = (a*d)-(b*c);
        actiontarget.setText(Integer.toString(determinant));
    }

}
