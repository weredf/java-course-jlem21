package school;

public class Grade {
	
	private Profession profession;
	public static final int MIN_SCORE = 40;
	private int score = MIN_SCORE;
	public static final int MAX_SCORE = 100;
		
	public Grade() {
		super();
	}

	public Grade(Profession profession) {
		super();
		this.profession = profession;
	}

	public Grade(Profession profession, int score) {
		super();
		this.profession = profession;
		this.score = score;
	}


	public Profession getProfession() {
		return profession;
	}


	public int getScore() {
		return score;
	}


	public void setProfession(Profession profession) {
		this.profession = profession;
	}


	public void setScore(int score) {
		if (score<=MAX_SCORE) {
			this.score = score;
		}
	}


	@Override
	public String toString() {
		return "Grade [profession=" + profession + ", score=" + score + "]";
	}


}
