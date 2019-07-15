package com.qqSpace.domain;

public class Friend {
    private Integer fid;
    private Integer tuid;
   // private Integer fuid;
    private User fuser;
    private Integer fstatus;
    private Integer rstatus;

    public Integer getFid() {
        return fid;
    }
    
    public User getFuser() {
		return fuser;
	}

	public void setFuser(User fuser) {
		this.fuser = fuser;
	}

	public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

/*    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }*/

	public Integer getFstatus() {
		return fstatus;
	}

	public void setFstatus(Integer fstatus) {
		this.fstatus = fstatus;
	}

	public Integer getRstatus() {
		return rstatus;
	}

	public void setRstatus(Integer rstatus) {
		this.rstatus = rstatus;
	}

}
