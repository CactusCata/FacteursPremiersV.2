package fr.cactuscata.primenumber.utils;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public final class ProgressBar {

	private final JProgressBar progress;
	private final JFrame frame = new JFrame("Chargement...");
	private final int end;
	private int cached;

	public ProgressBar(int end) {
		this(0, end);
	}

	public ProgressBar(final int min, final int max) {
		this.progress = new JProgressBar(min, 100);
		this.end = max;
	}

	public final void ini() {
		final JPanel pane = new JPanel();
		final JLabel text = new JLabel("Chargement...");
		pane.add("Center", this.progress);
		pane.add("Center", text);
		pane.getComponent(0);
		this.frame.getContentPane().add(BorderLayout.CENTER, pane);
		this.frame.setSize(275, 85);
		this.frame.setLocation(400, 500);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
	}

	public final void add() {
		this.cached++;
		this.progress.setValue(100 * this.cached / this.end);
	}

	public final void close() {
		this.frame.dispatchEvent(new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING));
		Thread.currentThread().interrupt();
	}

}
