package com.booking.View.ViewForUser;

import static com.booking.View.ViewMain.SignIn.signedIn;

public class Notifications {
    public void notifications() {
        System.out.println("*************** Thông báo **************");
        System.out.println(signedIn.getNotification());
    }
}
