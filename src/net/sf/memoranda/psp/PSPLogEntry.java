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

		/**
		 * @return the planSize
		 */
		public int getPlanSize() {
			return planSize;
		}

		/**
		 * @param planSize the planSize to set
		 */
		public void setPlanSize(int planSize) {
			this.planSize = planSize;
		}

		/**
		 * @return the actualSize
		 */
		public int getActualSize() {
			return actualSize;
		}

		/**
		 * @param actualSize the actualSize to set
		 */
		public void setActualSize(int actualSize) {
			this.actualSize = actualSize;
		}

		/**
		 * @return the toDateSize
		 */
		public int getToDateSize() {
			return toDateSize;
		}

		/**
		 * @param toDateSize the toDateSize to set
		 */
		public void setToDateSize(int toDateSize) {
			this.toDateSize = toDateSize;
		}

		/**
		 * @return the toDatePercent
		 */
		public double getToDatePercent() {
			return toDatePercent;
		}

		/**
		 * @param toDatePercent the toDatePercent to set
		 */
		public void setToDatePercent(double toDatePercent) {
			this.toDatePercent = toDatePercent;
		}



	}