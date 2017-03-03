package ALGraph;
import topologicalSort.LinkStack;

public class ALGraphh {
	String a="";
    private static boolean[] visited;
	private int vexNum,arcNum;
	private VNode[] vexs;
	public ALGraphh(){
		this(0,0,null);
	}
	public ALGraphh(int vexNum, int arcNum, VNode[] vexs) {
		// TODO 自动生成的构造函数存根
		this.vexNum=vexNum;
		this.arcNum=arcNum;
		this.vexs=vexs;
	}
	
	public void createUDN(String a,String b,String[] m,String n){
		String []l;
		vexNum=Integer.parseInt(a);
		arcNum=Integer.parseInt(b);
		vexs=new VNode[vexNum];
		for(int v=0;v<vexNum;v++)
			vexs[v]=new VNode((m[v]));
		l=n.split(",");
		for(int k=0;k<arcNum;k++){
			String []w=l[k].split(" ");
			int	v = locateVex(w[0]);
			int	u = locateVex(w[1]);
		    int value=Integer.parseInt(w[2]);
		    addArc(v,u,value);
		    addArc(u,v,value);
		}
	}
	
	
	
	public void addArc(int v, int u, int value) {
		// TODO 自动生成的方法存根
		ArcNode arc=new ArcNode(u,value);
		arc.setNextArc(vexs[v].getFirstArc());
		vexs[v].setFirstArc(arc);
	}
	
	
	public void createDN(String a,String b,String[] m,String n){
		String []l;
		vexNum=Integer.parseInt(a);
		arcNum=Integer.parseInt(b);
		vexs=new VNode[vexNum];
		for(int v=0;v<vexNum;v++)
			vexs[v]=new VNode((m[v]));
		l=n.split(",");
		for(int k=0;k<arcNum;k++){
			String []w=l[k].split(" ");
			int	v = locateVex(w[0]);
			int	u = locateVex(w[1]);
		    int value=Integer.parseInt(w[2]);
		    addArc(v,u,value);
		}
	}
	
	
	
	public int getVexNum() {
		// TODO 自动生成的方法存根
		return vexNum;
	}


	public int getArcNum() {
		// TODO 自动生成的方法存根
		return arcNum;
	}


	public Object getVex(int v) throws Exception {
		// TODO 自动生成的方法存根
		if(v<0 || v>=vexNum)
			throw new Exception("第"+v+"个顶点不存在！");
		return vexs[v].getData();
	}

	
	public int locateVex(Object vex) {
		// TODO 自动生成的方法存根
		for(int v=0;v<vexNum;v++)
			if(vexs[v].getData().equals(vex))
			return v;
		return -1;
	}

	
	public int firstAdjVex(int v) throws Exception {
		// TODO 自动生成的方法存根
		if(v<0 || v>=vexNum)
			throw new Exception("第"+v+"个顶点不存在！");
		VNode vex=vexs[v];
		if(vex.getFirstArc()!=null)
		    return vex.getFirstArc().getAdjVex();
		else
			return -1;
	}

	
	public int nextAdjVex(int v, int w) throws Exception {
		// TODO 自动生成的方法存根
		if(v<0 || v>=vexNum)
			try {
				throw new Exception("第"+v+"个顶点不存在");
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		VNode vex=vexs[v];
		ArcNode arcvw=null;
		for(ArcNode arc=vex.getFirstArc();arc!=null;arc=arc.getNextArc())
			if(arc.getAdjVex()==w){
				arcvw=arc;
				break;
			}
		if(arcvw!=null && arcvw.getNextArc()!=null)
			return arcvw.getNextArc().getAdjVex();
		else
		return -1;
	}

	
public VNode[] getVexs(){
	return vexs;
}
public int[] findInDegree(ALGraphh G) throws Exception{
	int [] indegree=new int [G.getVexNum()];
	for(int i=0;i<G.getVexNum();i++)
		for(ArcNode arc=G.getVexs()[i].getFirstArc();arc!=null;arc=arc.getNextArc())
			++indegree[arc.getAdjVex()];
	return indegree;		
}
public  String topologicalSort(ALGraphh G) throws Exception{
	int count=0;
	int [] indegree=findInDegree(G);
	LinkStack S=new LinkStack();
	for(int i=0;i<G.getVexNum();i++)
		if(indegree[i]==0)
			S.push(i);
	while(!S.isEmpty()){
		int i=(Integer)S.pop();
		a+=G.getVex(i)+"\n";
		++count;
		for(ArcNode arc=G.getVexs()[i].getFirstArc();arc!=null;arc=arc.getNextArc())
		{
			int k=arc.getAdjVex();
			if(--indegree[k]==0)
				S.push(k);
		}
	}
	if(count<G.getVexNum())
		return "有向网有回路！";
	else
		return "拓扑排序成功！"+a;	
}

}
