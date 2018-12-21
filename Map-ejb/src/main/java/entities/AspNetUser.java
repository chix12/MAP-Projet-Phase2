package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the AspNetUsers database table.
 * 
 */
@Entity
@Table(name="AspNetUsers")
@NamedQuery(name="AspNetUser.findAll", query="SELECT a FROM AspNetUser a")
public class AspNetUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="AccessFailedCount")
	private int accessFailedCount;

	@Column(name="AccountType")
	private String accountType;

	@Column(name="Category")
	private String category;

	@Column(name="Discriminator")
	private String discriminator;

	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name="LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private Timestamp lockoutEndDateUtc;

	@Column(name="Name")
	private String name;

	@Column(name="Name1")
	private String name1;

	@Column(name="PasswordHash")
	private String passwordHash;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name="Photo")
	private String photo;

	@Column(name="Rating")
	private int rating;

	@Column(name="SecurityStamp")
	private String securityStamp;

	@Column(name="Seniority")
	private String seniority;

	@Column(name="Specialty")
	private String specialty;

	@Column(name="Status")
	private String status;

	@Column(name="TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name="Type")
	private String type;

	@Column(name="UserName")
	private String userName;

	//bi-directional many-to-one association to AspNetUserClaim
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserClaim> aspNetUserClaims;

	//bi-directional many-to-one association to AspNetUserLogin
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserLogin> aspNetUserLogins;

	//bi-directional many-to-one association to JobRequest
	@ManyToOne
	@JoinColumn(name="JobRequest_IdRequest")
	private JobRequest jobRequest;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="IdProfile")
	private Profile profile;

	//bi-directional many-to-one association to Competence
	@OneToMany(mappedBy="aspNetUser")
	private List<Competence> competences;

	//bi-directional many-to-one association to File
	@OneToMany(mappedBy="aspNetUser")
	private List<File> files;

	//bi-directional many-to-one association to Mandat
	@OneToMany(mappedBy="aspNetUser")
	private List<Mandat> mandats;

	//bi-directional many-to-one association to Meeting
	@OneToMany(mappedBy="aspNetUser1")
	private List<Meeting> meetings1;

	//bi-directional many-to-one association to Meeting
	@OneToMany(mappedBy="aspNetUser2")
	private List<Meeting> meetings2;

	//bi-directional many-to-one association to Meeting
	@OneToMany(mappedBy="aspNetUser3")
	private List<Meeting> meetings3;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="aspNetUser1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="aspNetUser2")
	private List<Message> messages2;

	//bi-directional many-to-one association to OrganizationalChart
	@OneToMany(mappedBy="aspNetUser1")
	private List<OrganizationalChart> organizationalCharts1;

	//bi-directional many-to-one association to OrganizationalChart
	@OneToMany(mappedBy="aspNetUser2")
	private List<OrganizationalChart> organizationalCharts2;

	//bi-directional many-to-many association to Project
	@ManyToMany(mappedBy="aspNetUsers")
	private List<Project> projects1;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="aspNetUser")
	private List<Project> projects2;

	public AspNetUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName1() {
		return this.name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public String getSeniority() {
		return this.seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<AspNetUserClaim> getAspNetUserClaims() {
		return this.aspNetUserClaims;
	}

	public void setAspNetUserClaims(List<AspNetUserClaim> aspNetUserClaims) {
		this.aspNetUserClaims = aspNetUserClaims;
	}

	public AspNetUserClaim addAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().add(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(this);

		return aspNetUserClaim;
	}

	public AspNetUserClaim removeAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().remove(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(null);

		return aspNetUserClaim;
	}

	public List<AspNetUserLogin> getAspNetUserLogins() {
		return this.aspNetUserLogins;
	}

	public void setAspNetUserLogins(List<AspNetUserLogin> aspNetUserLogins) {
		this.aspNetUserLogins = aspNetUserLogins;
	}

	public AspNetUserLogin addAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().add(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(this);

		return aspNetUserLogin;
	}

	public AspNetUserLogin removeAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().remove(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(null);

		return aspNetUserLogin;
	}

	public JobRequest getJobRequest() {
		return this.jobRequest;
	}

	public void setJobRequest(JobRequest jobRequest) {
		this.jobRequest = jobRequest;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public Competence addCompetence(Competence competence) {
		getCompetences().add(competence);
		competence.setAspNetUser(this);

		return competence;
	}

	public Competence removeCompetence(Competence competence) {
		getCompetences().remove(competence);
		competence.setAspNetUser(null);

		return competence;
	}

	public List<File> getFiles() {
		return this.files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public File addFile(File file) {
		getFiles().add(file);
		file.setAspNetUser(this);

		return file;
	}

	public File removeFile(File file) {
		getFiles().remove(file);
		file.setAspNetUser(null);

		return file;
	}

	public List<Mandat> getMandats() {
		return this.mandats;
	}

	public void setMandats(List<Mandat> mandats) {
		this.mandats = mandats;
	}

	public Mandat addMandat(Mandat mandat) {
		getMandats().add(mandat);
		mandat.setAspNetUser(this);

		return mandat;
	}

	public Mandat removeMandat(Mandat mandat) {
		getMandats().remove(mandat);
		mandat.setAspNetUser(null);

		return mandat;
	}

	public List<Meeting> getMeetings1() {
		return this.meetings1;
	}

	public void setMeetings1(List<Meeting> meetings1) {
		this.meetings1 = meetings1;
	}

	public Meeting addMeetings1(Meeting meetings1) {
		getMeetings1().add(meetings1);
		meetings1.setAspNetUser1(this);

		return meetings1;
	}

	public Meeting removeMeetings1(Meeting meetings1) {
		getMeetings1().remove(meetings1);
		meetings1.setAspNetUser1(null);

		return meetings1;
	}

	public List<Meeting> getMeetings2() {
		return this.meetings2;
	}

	public void setMeetings2(List<Meeting> meetings2) {
		this.meetings2 = meetings2;
	}

	public Meeting addMeetings2(Meeting meetings2) {
		getMeetings2().add(meetings2);
		meetings2.setAspNetUser2(this);

		return meetings2;
	}

	public Meeting removeMeetings2(Meeting meetings2) {
		getMeetings2().remove(meetings2);
		meetings2.setAspNetUser2(null);

		return meetings2;
	}

	public List<Meeting> getMeetings3() {
		return this.meetings3;
	}

	public void setMeetings3(List<Meeting> meetings3) {
		this.meetings3 = meetings3;
	}

	public Meeting addMeetings3(Meeting meetings3) {
		getMeetings3().add(meetings3);
		meetings3.setAspNetUser3(this);

		return meetings3;
	}

	public Meeting removeMeetings3(Meeting meetings3) {
		getMeetings3().remove(meetings3);
		meetings3.setAspNetUser3(null);

		return meetings3;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setAspNetUser1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setAspNetUser1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setAspNetUser2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setAspNetUser2(null);

		return messages2;
	}

	public List<OrganizationalChart> getOrganizationalCharts1() {
		return this.organizationalCharts1;
	}

	public void setOrganizationalCharts1(List<OrganizationalChart> organizationalCharts1) {
		this.organizationalCharts1 = organizationalCharts1;
	}

	public OrganizationalChart addOrganizationalCharts1(OrganizationalChart organizationalCharts1) {
		getOrganizationalCharts1().add(organizationalCharts1);
		organizationalCharts1.setAspNetUser1(this);

		return organizationalCharts1;
	}

	public OrganizationalChart removeOrganizationalCharts1(OrganizationalChart organizationalCharts1) {
		getOrganizationalCharts1().remove(organizationalCharts1);
		organizationalCharts1.setAspNetUser1(null);

		return organizationalCharts1;
	}

	public List<OrganizationalChart> getOrganizationalCharts2() {
		return this.organizationalCharts2;
	}

	public void setOrganizationalCharts2(List<OrganizationalChart> organizationalCharts2) {
		this.organizationalCharts2 = organizationalCharts2;
	}

	public OrganizationalChart addOrganizationalCharts2(OrganizationalChart organizationalCharts2) {
		getOrganizationalCharts2().add(organizationalCharts2);
		organizationalCharts2.setAspNetUser2(this);

		return organizationalCharts2;
	}

	public OrganizationalChart removeOrganizationalCharts2(OrganizationalChart organizationalCharts2) {
		getOrganizationalCharts2().remove(organizationalCharts2);
		organizationalCharts2.setAspNetUser2(null);

		return organizationalCharts2;
	}

	public List<Project> getProjects1() {
		return this.projects1;
	}

	public void setProjects1(List<Project> projects1) {
		this.projects1 = projects1;
	}

	public List<Project> getProjects2() {
		return this.projects2;
	}

	public void setProjects2(List<Project> projects2) {
		this.projects2 = projects2;
	}

	public Project addProjects2(Project projects2) {
		getProjects2().add(projects2);
		projects2.setAspNetUser(this);

		return projects2;
	}

	public Project removeProjects2(Project projects2) {
		getProjects2().remove(projects2);
		projects2.setAspNetUser(null);

		return projects2;
	}

}