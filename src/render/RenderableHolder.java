package render;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
	
	private List<Irenderable> entities;
	private Comparator<Irenderable> comparator;
	
	public RenderableHolder() {
		entities = new ArrayList<Irenderable>();
		comparator = (Irenderable o1, Irenderable o2) -> {
			if(o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	
	public void add(Irenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public void update() {
		for(int i = entities.size() - 1; i >= 0; i--) {
			if(entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}
}
