package PackageMain;


import javax.security.auth.login.LoginException;

import Commands.cmdHelp;
import Commands.cmdNow;
import Commands.cmdPing;
import Commands.cmdPlay;
import Commands.cmdQueue;
import Commands.cmdShuffle;
import Commands.cmdSkip;
import Commands.cmdStop;
import Commands.cmdVolume;
import PackageCommands.CommandHandler;
import PackageCommands.MessageListener;
import PackageListener.OnJoinEvent;
import PackageListener.OnLeaveEvent;
import PackageListener.ReadyListener;
import PackageMusic.ClassMusic;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class BotMain {
	static JDA jda;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

	   String token = "TOKEN";
	    JDABuilder jdaBuilderVar = new JDABuilder(AccountType.BOT).setToken(token).setAutoReconnect(true)
	    									.setActivity(Activity.listening("/help twitch/b1ghouse"));
	    
	    jdaBuilderVar.addEventListeners(new ReadyListener());
	    jdaBuilderVar.addEventListeners(new MessageListener());
	    jdaBuilderVar.addEventListeners(new OnJoinEvent());
	    jdaBuilderVar.addEventListeners(new OnLeaveEvent());
	    
        CommandHandler.commands.put("help", new cmdHelp());
        CommandHandler.commands.put("ping", new cmdPing()); 
        CommandHandler.commands.put("play", new cmdPlay());
        CommandHandler.commands.put("stop", new cmdStop());
        CommandHandler.commands.put("skip", new cmdSkip());
        CommandHandler.commands.put("queue", new cmdQueue());
        CommandHandler.commands.put("now", new cmdNow());
        CommandHandler.commands.put("shuffle", new cmdShuffle());
        CommandHandler.commands.put("volume", new cmdVolume());
        CommandHandler.commands.put("", new ClassMusic());
        
        try {
        	jda = jdaBuilderVar.build();
        }catch (LoginException e){
            System.out.println("Error: " + e);
        }
	}	
}