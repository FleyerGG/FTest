package ru.fleyer.ftest.commands.maptool;

import fr.zcraft.quartzlib.components.commands.CommandException;
import fr.zcraft.quartzlib.components.commands.CommandInfo;
import ru.fleyer.ftest.commands.IoMCommand;
import ru.fleyer.ftest.gui.NewGuis.MainMenu;
import ru.fleyer.ftest.gui.NewGuis.PlayerMapsGui;


@CommandInfo(name = "test", usageParameters = "[player name]")

public class test extends IoMCommand {


    @Override
    protected void run() throws CommandException {
        MainMenu.onMainMenu(playerSender());
        //PlayerMapsGui.onMapsGui(playerSender());
    }
}
