package CustomlistAndOrdering;
import java.time.LocalDate;

/**
 *
 * @author Abdullah
 */

/**
 * Its a sample class which represents a File
 * that has a Name,Size,Creation Date and Type.
 * 
 * The Class has some custom compare methods using different properties i.e File Name, Creation Date,  Name & Size etc
 * 
 * */
public class File implements Comparable<File> {

    String fileName;
    double fileSize;
    LocalDate creationDate;
    String fileType;

	public File(String fileName, double fileSize, LocalDate creationDate, String fileType) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.creationDate = creationDate;
        this.fileType = fileType;
    }
	
    @Override
    public String toString() {
        return "File " + "fileName= " + fileName + ", fileSize= " + fileSize + ", creationDate= " + creationDate + ", fileType= " + fileType;
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fileSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (Double.doubleToLongBits(fileSize) != Double.doubleToLongBits(other.fileSize))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		return true;
	}

    /**
     * Compare two files using their Name
     * @param File o
     * @return -ve if less than
     * @return 0 if Equal
     * @return +ve if greater than
     * */ 
	
    public int compareByName(File o) {
        return fileName.compareTo(o.getFileName());
    }
    
    /**
     * Compare two files using their Name and Size
     * */ 
    public int compareByNameAndSize(File o) {
        int i =  this.compareByName(o);
        
        if(i<0){
            return -1;
        }
        else if(i==0){
            return this.compareBySize(o);
        }
        else{
            return 1;
        }
    }
    
    /**
     * Compare two files using their Types
     * 
     * */ 
    public int compareByType(File o) {
        return fileType.compareTo(o.getFileType());
    }

    /**
     * Compare two files using their Size
     * 
     * */ 
    public int compareBySize(File o) {
        double d = fileSize - o.getFileSize();
        if (d < 0) {
            return -1;
        } else if (d > 0) {
            return 1;
        } else {
            return 0;
        }
    }
    /**
     * Compare two files using their Creation Date
     * 
     * */ 
    public int compareByCreationDate(File o){
        return creationDate.compareTo(o.getCreationDate());
    }
    
    /**
     * @Override compareTo() methods which compare two files using their Name
     * 
     * */ 
    
    @Override
    public int compareTo(File o) {  // using fileName
        return fileName.compareTo(o.getFileName());
    }

	public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

}
