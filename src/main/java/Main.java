public class Main {
    public static void main(String[] args) {

        //temporary
        //logo
        Menu.mainMenu();
        //Wikipedia definition of CRM - after user will input "definition" as an input
        Menu.CRMDefinition();
        //Wikipedia definition of CRM (Club Ricky Martin) - after user will input "true definition" as an input
        Graphics.trueCRMGraphic();
        Menu.CRMTrueDefinition();
        //new lead with empty constructor - user will be prompted for the input
        System.out.println();
        Lead tl = new Lead();
        System.out.println(tl.showLeadDetails());

    }
}
