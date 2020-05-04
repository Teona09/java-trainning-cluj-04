public class Person {
    private String name;
    private String job;
    private String university;
    private boolean drivingLicence;
    private boolean isMaried;

    public String getName(){return this.name;}
    public String getJob(){return this.job;}
    public String getUniversity(){return this.university;}
    public boolean getDrivingLicence(){return this.drivingLicence;}
    public boolean getIsMaried() { return this.isMaried; }

    private Person(Builder builder){
        this.name=builder.name;
        this.job=builder.job;
        this.university=builder.university;
        this.drivingLicence=builder.drivingLicence;
        this.isMaried=builder.isMaried;
    }

    @Override
    public String toString(){
        return "name: "+name+"; job: "+job+"; university: "+university+
                "; driving Licence: "+drivingLicence+"; maried: "+isMaried;
    }

    public static class Builder{
        private String name;//required parameters
        private String job;//optional parameters
        private String university;//optional parameters
        private boolean drivingLicence;//optional parameters
        private boolean isMaried;//optional parameters

        public Builder(String name){this.name=name;}

        public Builder setJob(String job){
            this.job=job;
            return this;
        }

        public Builder setUniverstity(String university){
            this.university=university;
            return this;
        }

        public Builder setDrivingLicence(boolean drivingLicence){
            this.drivingLicence=drivingLicence;
            return this;
        }

        public Builder setIsMaried(boolean isMaried){
            this.isMaried=isMaried;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
