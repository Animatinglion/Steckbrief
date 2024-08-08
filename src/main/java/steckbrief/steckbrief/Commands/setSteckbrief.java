package steckbrief.steckbrief.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;


public class setSteckbrief implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {

        if (!(sender instanceof Player)){ //Sender die keine Spieler sind werden aussortiert
            sender.sendMessage("nur Spieler können diesen Befehl verwenden");
            return false;
        }

        String zwName = ((Player) sender).getDisplayName();

        if(args.length < 3){
            sender.sendMessage("gib /setSteckbrief <Name> <Beruf> <Alter> ein");
            return true;
        }

        String[] zwarray = new String[4];
        zwarray[0] = args[0] + " "; //Name
        zwarray[1] = args[1] + " "; //Beruf
        zwarray[2] = args[2] + " "; //Alter

        if(args.length > 3) {
            String s1 = "";
            for(int i = 3; i < args.length ; i++){
                s1 += args[i] + " ";
            }
            zwarray[3] = s1;
        }

        DataHolder zw = new DataHolder(new ArrayList<String[]>(), new ArrayList<String>());
        zw.LoadDataHolder(new String[0]);

        if(zw.names.contains(zwName)){
            int index = zw.names.indexOf(zwName);
            String[] sent = zw.arrays.get(index);
            zw.arrays.set(index,zwarray);
            sender.sendMessage("Steckbrief wurde Aktualisiert von:");
            sender.sendMessage("Name: " + sent[0]);
            sender.sendMessage("Beruf: " + sent[1]);
            sender.sendMessage("Alter: " + sent[2]);
            sender.sendMessage("Zusatz: " + sent[3]);
            sender.sendMessage("zu:");
            sent = zw.arrays.get(index);
            sender.sendMessage("Name: " + sent[0]);
            sender.sendMessage("Beruf: " + sent[1]);
            sender.sendMessage("Alter: " + sent[2]);
            sender.sendMessage("Zusatz: " + sent[3]);
        } else {

            zw.names.add(zwName);
            zw.arrays.add(zwarray);
            sender.sendMessage("Steckbrief wurde erstellt:");
            sender.sendMessage("Name: " + zwarray[0]);
            sender.sendMessage("Beruf: " + zwarray[1]);
            sender.sendMessage("Alter: " + zwarray[2]);
            sender.sendMessage("Zusatz: " + zwarray[3]);
            zw.saveDataHolder(new String[0]);
        }


        return true;
    }
}
