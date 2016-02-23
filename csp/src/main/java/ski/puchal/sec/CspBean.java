package ski.puchal.sec;

public class CspBean {
	private boolean scriptSrcNone;
	private boolean scriptSrcSelf;
	private boolean scriptSrcUnsafeInline;
	private boolean scriptSrcSha;
	private boolean scirptSrcNonce;

	public boolean isScriptSrcNone() {
		return scriptSrcNone;
	}

	public void setScriptSrcNone(boolean scriptSrcNone) {
		this.scriptSrcNone = scriptSrcNone;
	}

	public boolean isScriptSrcSelf() {
		return scriptSrcSelf;
	}

	public void setScriptSrcSelf(boolean scriptSrcSelf) {
		this.scriptSrcSelf = scriptSrcSelf;
	}

	public boolean isScriptSrcUnsafeInline() {
		return scriptSrcUnsafeInline;
	}

	public void setScriptSrcUnsafeInline(boolean scriptSrcUnsafeInline) {
		this.scriptSrcUnsafeInline = scriptSrcUnsafeInline;
	}

	public boolean isScriptSrcSha() {
		return scriptSrcSha;
	}

	public void setScriptSrcSha(boolean scriptSrcSha) {
		this.scriptSrcSha = scriptSrcSha;
	}

	public boolean isScirptSrcNonce() {
		return scirptSrcNonce;
	}

	public void setScirptSrcNonce(boolean scirptSrcNonce) {
		this.scirptSrcNonce = scirptSrcNonce;
	}

}
