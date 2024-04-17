package com.sg.dvdLibrary;

import com.sg.dvdLibrary.controller.DVDController;
import com.sg.dvdLibrary.dao.DVDLibraryDao;
import com.sg.dvdLibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdLibrary.ui.DVDLibraryView;
import com.sg.dvdLibrary.ui.UserIO;
import com.sg.dvdLibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO userIO = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(userIO);
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        DVDController controller = new DVDController(dao,view);
        controller.run();
    }
}
