package objects;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import zeroComputation.Point;
import zeroComputation.STLParser;

public class STL extends Obj {
	public STL(String path) {
		super();
		Path filePath = Paths.get(path);
		List<Point[]> faces = null;
		try {
			faces = STLParser.parseSTLFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int length = faces.get(0).length;

		faces.forEach(face -> {
			int[] f = new int[length];
			for (int i = 0; i < length; i++) {
				if (i < length - 1) {
					vertices.add(new int[] { edges.size(), edges.size() + 1 });
				} else {
					vertices.add(new int[] { edges.size(), edges.size() - 2 });
				}
				f[i] = edges.size();
				edges.add(new Point(face[i].getData(0, 0),face[i].getData(1, 0),face[i].getData(2, 0),1));
			}
			this.faces.add(f);
		});

		//	cleanUpData();
	}

}
