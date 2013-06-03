package com.tcc.app;

public class Image {

	private int id, resourceId;
	private String value;

	public Image(int id, int resourceId, String value) {
		super();
		this.value = value;
		this.id = id;
		this.resourceId = resourceId;

	}

	public Image(int id) {
		super();
		this.id = id;
	}

	public String getvalue() {
		return value;
	}

	public int getResourceId() {
		return resourceId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
