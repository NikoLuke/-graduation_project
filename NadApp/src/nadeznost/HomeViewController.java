package nadeznost;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXToolbar;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeViewController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXToolbar toolbar;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private AnchorPane homeAnchor;

    @FXML
    private JFXDrawer drawer;

    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            VBox box = FXMLLoader.load(getClass().getResource("Drawer.fxml"));
            AnchorPane labwork1 = FXMLLoader.load(getClass().getResource("/labwork1/LabWork.fxml"));
//            setNode(labwork1);
            drawer.setSidePane(box);

            for (Node node : box.getChildren()) {
                if (node.getId() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
                        switch (node.getId()) {
                            case "lw1":
                                drawer.close();
                                setNode(labwork1);
                                break;
                        }
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        HamburgerSlideCloseTransition burger = new HamburgerSlideCloseTransition(hamburger);
        burger.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
            burger.setRate(burger.getRate() * -1);
//            burger.play();

            if (drawer.isShown()) {
                drawer.close();
            }
            else drawer.open();
        });
    }

    private void setNode(Node node) {
        homeAnchor.getChildren().clear();
        homeAnchor.getChildren().add(node);
    }
}
