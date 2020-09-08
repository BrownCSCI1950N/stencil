package debugger.support;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Display extends Application {
	
	private static Stage _stage = null;
	public static float getStageWidth() {
		return _stage == null ? 0 : (float) _stage.getWidth();
	}
	public static float getStageHeight() {
		return _stage == null ? 0 : (float) _stage.getHeight() - 20;
	}
	public static void setResizable(boolean b) {
		if(_stage != null) _stage.setResizable(b);
	}
	public static void setTitle(String title) {
		if(_stage != null) _stage.setTitle("Collision Debugger: " + title);
	}
	public static int getDefaultWeek() {
		return week;
	}

	// TODO: change the week number to one of { 2, 3, 5, 6 } to debug more things
	private static int week = 2;
		
	public static void main(String[] argv) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		_stage = stage;
		
		String title = "Collision Debugger: Week " + Integer.toString(week);
		stage.setTitle(title);
		
		
		stage.setWidth(UIConstants.STAGE_WIDTH);
		stage.setHeight(UIConstants.STAGE_HEIGHT);
		Pane pane = new Pane();
		Scene scene = new Scene(pane, UIConstants.STAGE_WIDTH, UIConstants.STAGE_HEIGHT);
		stage.setScene(scene);
				
		CollisionCanvas canvas = new CollisionCanvas();	
		scene.setOnKeyPressed(e -> {
			canvas.onKeyPressed(e);
		});
		pane.getChildren().add(canvas.getRoot());
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
		
		stage.widthProperty().addListener((obs, oldVal, newVal) -> {
			canvas.rebind();
		});
		stage.heightProperty().addListener((obs, oldVal, newVal) -> {
			canvas.rebind();
		});
		
		stage.show();
		
	}

}
