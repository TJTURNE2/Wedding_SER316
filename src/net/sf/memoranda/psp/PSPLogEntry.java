/**
 * 
 */
package net.sf.memoranda.psp;

/**
 * @author TErry Turner
 *
 */
//class to hold info for Phases
	@SuppressWarnings("serial")
	public class PSPLogEntry implements java.io.Serializable{

		private int planSize;
		private int actualSize;
		private int toDateSize;
		private double toDatePercent;

		public PSPLogEntry() {
			planSize = 0;
			actualSize = 0;
			toDateSize = 0;
			toDatePercent = 0;
		}

		public PSPLogEntry(int planSize, int actualSize, int toDateSize, double toDatePercent) {
			super();
			this.planSize = planSize;
			this.actualSize = actualSize;
			this.toDateSize = toDateSize;
			this.toDatePercent = toDatePercent;
		}

		protected int getPlanSize() {
			return planSize;
		}

		protected void setPlanSize(int planSize) {
			this.planSize = planSize;
		}

		protected int getActualSize() {
			return actualSize;
		}

		protected void setActualSize(int actualSize) {
			this.actualSize = actualSize;
		}

		protected int getToDateSize() {
			return toDateSize;
		}

		protected void setToDateSize(int toDateSize) {
			this.toDateSize = toDateSize;
		}

		protected double getToDatePercent() {
			return toDatePercent;
		}

		protected void setToDatePercent(double toDatePercent) {
			this.toDatePercent = toDatePercent;
		}

	}