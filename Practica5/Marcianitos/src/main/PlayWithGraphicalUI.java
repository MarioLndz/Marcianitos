/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import View.DeepSpaceView;
import View.UI.MainWindow;
import controller.Controller;
import deepspace.GameUniverse;

/**
 *
 * @author mario
 */
public class PlayWithGraphicalUI {
	public static void main(String[] args) {
      DeepSpaceView ui;
      GameUniverse game = new GameUniverse();
      ui = MainWindow.getInstance();
      Controller controller = Controller.getInstance();
      controller.setModelView(game,ui);
      controller.start();   
    }
	
}
