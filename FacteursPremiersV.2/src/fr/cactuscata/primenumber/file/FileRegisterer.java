package fr.cactuscata.primenumber.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.cactuscata.primenumber.utils.Msg;

public final class FileRegisterer {
	
	public static final List<Long> init() {

		final List<Long> primeNumbers = new ArrayList<>();

		final File file = new File(
				new File(FileRegisterer.class.getProtectionDomain().getCodeSource().getLocation().getPath())
						.getParentFile().getAbsolutePath() + "/recordednumbers.txt");

		try {

			if (!file.exists()) {
				file.createNewFile();
				updateFile(Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L));
			}

			final BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null)
				primeNumbers.add(Long.parseLong(line));
			reader.close();

		} catch (final IOException e) {
			Msg.sendBoxMessage(("Error while reading file:\n" + e.getMessage()));
		}

		return primeNumbers;

	}

	public static final void updateFile(final List<Long> primeNumbers) {

		final File file = new File(
				new File(FileRegisterer.class.getProtectionDomain().getCodeSource().getLocation().getPath())
						.getParentFile().getAbsolutePath() + "/recordednumbers.txt");
		file.delete();

		try {

			file.createNewFile();

			final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			for (final Long number : primeNumbers) {
				bufferedWriter.append(number + "");
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (final IOException e) {
			Msg.sendBoxMessage("Error while writing file: \n" + e.getMessage());
		}

	}

}
