package fr.cactuscata.primenumber.script;

import fr.cactuscata.primenumber.player.Learner;
import fr.cactuscata.primenumber.player.Worker;
import fr.cactuscata.primenumber.utils.Msg;

public final class Script {


	public final void modWanted() {

		if (Msg.getAnswer("Veuillez choisir 'learn' ou 'work'.", "learn", "work").equalsIgnoreCase("learn")) {

			if (Msg.getAnswer("Veuillez choisir 'time' ou 'interval'.", "time", "interval").equalsIgnoreCase("time"))
				new Learner().learn((int) Msg.getNumber("Veuillez choisir un temps d'apprentissage."));
			else
				new Learner().learn(Msg.getNumber("Veuillez choisir le premier nombre"),
						Msg.getNumber("Veuillez choisir le second nombre."));
		} else
			new Worker().getPrimeNumbers(Msg.getNumber("Veuillez choisir le nombre à décomposer."));
	}

}
