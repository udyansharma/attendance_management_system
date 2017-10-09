package project.ams.model;

import java.util.List;

public class Subbatch {
	private List<String> batches;
	private String subjct;
	public List<String> getBatches() {
		return batches;
	}
	public void setBatches(List<String> batches) {
		this.batches = batches;
	}
	public String getSubjct() {
		return subjct;
	}
	public void setSubjct(String subjct) {
		this.subjct = subjct;
	}
}