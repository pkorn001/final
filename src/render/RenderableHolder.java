package render;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
	
	private List<Renderable> entities;
	private Comparator<Renderable> comparator;
	
	public RenderableHolder() {
		entities = new ArrayList<Renderable>();
		comparator = (Renderable o1, Renderable o2) -> {
			if(o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	
	public void add(Renderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
	}
}
