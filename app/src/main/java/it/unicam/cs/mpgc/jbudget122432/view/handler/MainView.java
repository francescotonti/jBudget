package it.unicam.cs.mpgc.jbudget122432.view.handler;

import it.unicam.cs.mpgc.jbudget122432.controller.ILedgerController;
import it.unicam.cs.mpgc.jbudget122432.controller.IStatisticsController;
import it.unicam.cs.mpgc.jbudget122432.controller.ITagController;
import it.unicam.cs.mpgc.jbudget122432.model.movements.Movement;
import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Setter
public class MainView {

    private ILedgerController ledgerController;
    private ITagController tagController;
    private IStatisticsController statisticsController;
    private User user;

    @FXML
    private MenuButton mnBtnTag;
    @FXML
    private Label lblIn;
    @FXML
    private Label lblOut;
    @FXML
    private Label lblBalance;
    @FXML
    private TableView<Movement> tblMovement;

    /*public MainView(ILedgerController ledgerController,ITagController tagController,IStatisticsController statisticsController) {
        this.ledgerController = ledgerController;
        this.tagController = tagController;
        this.statisticsController = statisticsController;
    }*/

    @FXML
    public void initialize() {
        /*List<MenuItem> tags = new LinkedList<>();
        for(Tag tag : tagController.getAllTags()){
            tags.add(new MenuItem(tag.getName()));
        }
        mnBtnTag.getItems().addAll(tags);

        lblIn.setText(Double.toString(ledgerController.getIncome(user.getLedger())));
        lblOut.setText(Double.toString(ledgerController.getExpense(user.getLedger())));
        lblBalance.setText(Double.toString(ledgerController.getBalance(user.getLedger())));*/
    }

    public void initAfterLoad(User user){
        this.user = user;
        List<MenuItem> tags = new LinkedList<>();
        for(Tag tag : tagController.getAllTags()){
            tags.add(new MenuItem(tag.getName()));
        }
        mnBtnTag.getItems().addAll(tags);

        lblIn.setText(Double.toString(ledgerController.getIncome(this.user.getLedger())));
        lblOut.setText(Double.toString(ledgerController.getExpense(this.user.getLedger())));
        lblBalance.setText(Double.toString(ledgerController.getBalance(this.user.getLedger())));
    }

    public void handleAddMovement(ActionEvent actionEvent){
        System.out.println(1);
    }

    public void handleAddTag(ActionEvent actionEvent) {
        System.out.println(2);
    }
}
