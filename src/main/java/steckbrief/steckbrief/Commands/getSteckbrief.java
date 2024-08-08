package steckbrief.steckbrief.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;


public class getSteckbrief implements CommandExecutor {

@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){

    DataHolder zw = new DataHolder(new ArrayList<String[]>(), new ArrayList<String>());
    zw.LoadDataHolder(new String[0]);

    if(zw.names.contains(args[0])) { //prüft ob der gefragte Spieler in der VerzeichnisListe "names" existiert
        int index = zw.names.indexOf(args[0]);
        String[] sent = zw.arrays.get(index);
        sender.sendMessage("Steckbrief von: " + args[0]);
        sender.sendMessage("Name: " + sent[0]);
        sender.sendMessage("Beruf: " + sent[1]);
        sender.sendMessage("Alter: " + sent[2]);
        sender.sendMessage("Zusatz: " + sent[3]);
        return true;
    } else {
        sender.sendMessage(args[0] + " ist nicht da, bzw. hat keinen Steckbrief");
        return true;
    }
    }
}
