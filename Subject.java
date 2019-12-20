package pdf1;

public class Subject {
String subcode,internal,external;

public final String getSubcode() {
	return subcode;
}

public final void setSubcode(String subcode) {
	this.subcode = subcode;
}

public final String getInternal() {
	return internal;
}

public final void setInternal(String internal) {
	this.internal = internal;
}

public final String getExternal() {
	return external;
}

public final void setExternal(String external) {
	this.external = external;
}

@Override
public String toString() {
	return "Subject [subcode=" + subcode + ", internal=" + internal + ", external=" + external + "]";
}
public void display() {
	 System.out.println("Subject [subcode=" + subcode + ", internal=" + internal + ", external=" + external + "]");
	}
}
