public class Actor {
    private String firstName;

    private String lastName;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor(String firstAndLatName) {
        String[] separatedName = firstAndLatName.split(" ");
        this.firstName = separatedName[0];
        this.lastName = separatedName[1];
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean compareActors(Actor actor) {
        String actorName = this.firstName + " " + this.lastName;
        String otherActor = actor.firstName + " " + actor.lastName;
        return actorName.equals(otherActor);

    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
