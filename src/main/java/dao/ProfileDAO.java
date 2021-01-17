package dao;

import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {
	public static List<ProfileUser> ls = new ArrayList<>();

	public int update(ProfileUser pro) {
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getId().equals(pro.getId())) {
				ls.set(i, pro);
				return i;
			}
		}

		return -1;

	}

	public ProfileUser findByID(String id) {
		for (ProfileUser pro : ls) {
			if (pro.getId().equals(id)) {
				return pro;
			}
		}
		return null;
	}

	public int save(ProfileUser pro) {
		ls.add(pro);
		return 1;
	}

	public void dummydata() {
		// TODO Auto-generated method stub
		ls.add(new ProfileUser("0", "Khanh", "pic1.jpg"));
		ls.add(new ProfileUser("1", "Khanh1", "pic2.png"));
		ls.add(new ProfileUser("2", "Khanh2", "pic3.png"));
	}

	public List<ProfileUser> getAll() {
		dummydata();
		return ls;
	}
}
