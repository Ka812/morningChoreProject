import java.util.* ;

class Input {
    public static int askNumber(String Question) throws Exception {
        // tulostetaan kysymys
        System.out.println(Question);
        Comments.emptyLine(1) ;
        Scanner input = new Scanner(System.in);
        int feed = -1; //syöte
        boolean shallWeGoOn = true;
        // toista aina jos jatketaanko on true
        while(shallWeGoOn) {
            try {
                // jos tämä epäonnistuu, mennään catchiin
                feed = Integer.parseInt(input.nextLine());
                // jos onnistui, laitetaan shallWeGo falseksi.
                shallWeGoOn = false;
            } catch(Exception e) {
                System.out.println("wrong!");
                Comments.emptyLine(1) ;
                shallWeGoOn = true;
            }
        }
        // palautetaan käyttäjän syöte mitä se lopuksi antoi.
        return feed ;
    }

    public static void reactionForAwakeningTime(int aminutes, int sminutes, Locale locale) {
        ResourceBundle labels = ResourceBundle.getBundle("ui", locale);
        int number1 = aminutes ;
        int number2 = sminutes ;
        if  (number1 >= number2 ) {
            String comment1forawakening = labels.getString("reactionforawakeningtime11") ;
            System.out.println(comment1forawakening) ;
            sleep(1500);
            Comments.emptyLine(1) ;
            String comment2forawakening = labels.getString("reactionforawakeningtime12") ;
            System.out.println(comment2forawakening) ;
            sleep(1500);
            Comments.emptyLine(1) ;
            String comment3forawakening = labels.getString("reactionforawakeningtime13") ;
            System.out.println(comment3forawakening) ;
            sleep(1500);
            Comments.emptyLine(1) ;
            String comment4forawakening = labels.getString("reactionforawakeningtime14") ;
            System.out.println(comment4forawakening) ;
            sleep(1500);
        } else if (number1 + 15 >= number2 ) {
            String comment5forawakening = labels.getString("reactionforawakeningtime21") ;
            System.out.println(comment5forawakening) ;
            Comments.emptyLine(1) ;
            String comment6forawakening = labels.getString("reactionforawakeningtime22") ;
            System.out.println(comment6forawakening) ;
            sleep(1500);
        } else if (number1 + 30 >= number2) {
            String comment7forawakening = labels.getString("reactionforawakeningtime31") ;
            System.out.println(comment7forawakening) ;
            sleep(1500);
            Comments.emptyLine(1) ;
            String comment8forawakening = labels.getString("reactionforawakeningtime32") ;
            System.out.println(comment8forawakening) ;
            sleep(1500);
        } else if (number1 + 37 >= number2) {
            String comment9forawakening = labels.getString("reactionforawakeningtime1") ;
            System.out.println(comment9forawakening) ;
            sleep(1500);
            Comments.emptyLine(1) ;
            String comment10forawakening = labels.getString("reactionforawakeningtime2") ;
            System.out.println(comment10forawakening) ;
            sleep(1500);
        } else if (number1 + 48 >= number2) {
            String comment11forawakening = labels.getString("reactionforawakeningtime3") ;
            System.out.println(comment11forawakening) ;
            sleep(1500);
        } else {
            String comment12forawakening = labels.getString("reactionforawakeningtime4") ;
            System.out.println(comment12forawakening) ;
            sleep(1500);
        }
    }

    public static void sleep(int millisecs) {
        try {
           Thread.sleep(millisecs);
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
}