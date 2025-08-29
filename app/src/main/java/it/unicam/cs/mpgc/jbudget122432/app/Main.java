package it.unicam.cs.mpgc.jbudget122432.app;

import it.unicam.cs.mpgc.jbudget122432.controller.*;
import it.unicam.cs.mpgc.jbudget122432.model.movements.Ledger;
import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;
import it.unicam.cs.mpgc.jbudget122432.model.tags.TagRepository;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import it.unicam.cs.mpgc.jbudget122432.model.users.UserRepository;
import it.unicam.cs.mpgc.jbudget122432.view.handler.MainView;
import it.unicam.cs.mpgc.jbudget122432.view.handler.MovementView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        //loader.setController(new MovementView());
        UserRepository userRepository = new UserRepository();
        IUserController userController = new UserController(userRepository);
        TagRepository tagRepository = new TagRepository();
        ITagController tagController = new TagController(tagRepository);
        ILedgerController ledgerController = new LedgerController();
        IStatisticsController statisticsController = new StatisticsController(tagRepository);
        //MainView mainView = new MainView(ledgerController,tagController,statisticsController);
        /*MainView mainView = loader.getController();
        mainView.setStatisticsController(statisticsController);
        mainView.setLedgerController(ledgerController);
        mainView.setTagController(tagController);*/

        tagController.createTag("Food");
        tagController.createTag("Drink");
        tagController.createTag("Rent");
        User user = new User();
        user.setLedger(new Ledger(user));
        Parent root = loader.load();
        MainView mainView = loader.getController();
        mainView.setStatisticsController(statisticsController);
        mainView.setLedgerController(ledgerController);
        mainView.setTagController(tagController);
        mainView.initAfterLoad(user);
        Scene scene = new Scene(root);
        stage.setTitle("jBudget");
        stage.setScene(scene);
        stage.show();
    }
}
