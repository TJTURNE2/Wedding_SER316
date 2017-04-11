/**
 * 
 */
package net.sf.memoranda.psp;

@SuppressWarnings("serial")
public class PSPProjectLOCSummary implements java.io.Serializable{

	private PSPLogEntry Base;
	private PSPLogEntry Deleted;
	private PSPLogEntry Modified;
	private PSPLogEntry Added;
	private PSPLogEntry Reused;
	private PSPLogEntry AddedModified;
	private PSPLogEntry Total;
	private PSPLogEntry NewReused;

	public PSPProjectLOCSummary() {
		Base = new PSPLogEntry();
		Deleted = new PSPLogEntry();
		Modified = new PSPLogEntry();
		Added = new PSPLogEntry();
		Reused = new PSPLogEntry();
		AddedModified = new PSPLogEntry();
		Total = new PSPLogEntry();
		NewReused = new PSPLogEntry();
	}

	/**
	 * @param base
	 * @param deleted
	 * @param modified
	 * @param added
	 * @param reused
	 * @param addedModified
	 * @param total
	 * @param newReused
	 */
	public PSPProjectLOCSummary(PSPLogEntry base, PSPLogEntry deleted, PSPLogEntry modified, PSPLogEntry added,
			PSPLogEntry reused, PSPLogEntry addedModified, PSPLogEntry total, PSPLogEntry newReused) {
		super();
		Base = base;
		Deleted = deleted;
		Modified = modified;
		Added = added;
		Reused = reused;
		AddedModified = addedModified;
		Total = total;
		NewReused = newReused;
	}

	/**
	 * @return the base
	 */
	public PSPLogEntry getBase() {
		return Base;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(PSPLogEntry base) {
		Base = base;
	}

	/**
	 * @return the deleted
	 */
	public PSPLogEntry getDeleted() {
		return Deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set
	 */
	public void setDeleted(PSPLogEntry deleted) {
		Deleted = deleted;
	}

	/**
	 * @return the modified
	 */
	public PSPLogEntry getModified() {
		return Modified;
	}

	/**
	 * @param modified
	 *            the modified to set
	 */
	public void setModified(PSPLogEntry modified) {
		Modified = modified;
	}

	/**
	 * @return the added
	 */
	public PSPLogEntry getAdded() {
		return Added;
	}

	/**
	 * @param added
	 *            the added to set
	 */
	public void setAdded(PSPLogEntry added) {
		Added = added;
	}

	/**
	 * @return the reused
	 */
	public PSPLogEntry getReused() {
		return Reused;
	}

	/**
	 * @param reused
	 *            the reused to set
	 */
	public void setReused(PSPLogEntry reused) {
		Reused = reused;
	}

	/**
	 * @return the addedModified
	 */
	public PSPLogEntry getAddedModified() {
		return AddedModified;
	}

	/**
	 * @param addedModified
	 *            the addedModified to set
	 */
	public void setAddedModified(PSPLogEntry addedModified) {
		AddedModified = addedModified;
	}

	/**
	 * @return the total
	 */
	public PSPLogEntry getTotal() {
		return Total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(PSPLogEntry total) {
		Total = total;
	}

	/**
	 * @return the newReused
	 */
	public PSPLogEntry getNewReused() {
		return NewReused;
	}

	/**
	 * @param newReused
	 *            the newReused to set
	 */
	public void setNewReused(PSPLogEntry newReused) {
		NewReused = newReused;
	}

}