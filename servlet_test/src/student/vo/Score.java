package student.vo;

import java.sql.Date;

public class Score {

	protected int sno;
	protected String sname;
	protected int kor;
	protected int eng;
	protected int math;
	protected int totalScore ;
	protected int avgScore;
	protected String rankScore;
	
	
	public Score() {
		// TODO Auto-generated constructor stub
	
	}


	public int getSno() {
		return sno;
	}


	public Score setSno(int sno) {
		this.sno = sno;
		return this;
	}


	public String getSname() {
		return sname;
	}


	public Score setSname(String sname) {
		this.sname = sname;
		return this;
	}


	public int getKor() {
		return kor;
	}


	public Score setKor(int kor) {
		this.kor = kor;
		return this;
	}


	public int getEng() {
		return eng;
	}


	public Score setEng(int eng) {
		this.eng = eng;
		return this;
	}

	public int getMath() {
		return math;
	}


	public Score setMath(int math) {
		this.math = math;
		return this;
	}

	public int getTotalScore() {
		return totalScore;
	}


	public Score setTotalScore(int totalScore) {
		this.totalScore = totalScore;
		return this;
	}


	public int getAvgScore() {
		return avgScore;
	}


	public Score setAvgScore(int avgScore) {
		this.avgScore = avgScore;
		return this;
	}


	public String getRankScore() {
		return rankScore;
	}


	public Score setRankScore(String rankScore) {
		this.rankScore = rankScore;
		return this;
	}

	
	
}
