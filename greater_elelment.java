class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n=nums.length;
        int []nger=new int[n];
          int []res=new int[n];
          Arrays.fill(res,-1);
        Arrays.fill(nger,-1);
      Stack<Integer>st=new Stack<>();
    
    for(int i=n-1;i>=0;i--)
    {
        while(st.size()!=0&&nums[st.peek()]<=nums[i])
        {
            st.pop();

        }
        if(st.size()!=0)
        {
            nger[i]=st.peek();
        }
        st.push(i);
    }

    HashMap<Integer,List<Integer>>map=new HashMap<>();
for(int i=0;i<n;i++)
{
    if(nger[i]!=-1)
    {
      List<Integer>ls= map.getOrDefault(nger[i],new ArrayList<>());
      ls.add(i);
      map.put(nger[i],ls);
    }

}   
PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->nums[a]-nums[b]);
for(int i=0;i<n;i++)
{
    if(map.containsKey(i-1)) 
    {  for(int idx:map.get(i-1))
        {
            pq.add(idx);

        }
      
    }
       while(pq.size()!=0&&nums[pq.peek()]<nums[i])
        {
            res[pq.remove()]=nums[i];

        }

}


return res;


    }
}
