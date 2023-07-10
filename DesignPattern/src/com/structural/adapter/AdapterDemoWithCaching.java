package com.structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;


class PointDemo
{
  public int x, y;

  public PointDemo(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PointDemo PointDemo = (PointDemo) o;

    if (x != PointDemo.x) return false;
    return y == PointDemo.y;
  }

  @Override
  public int hashCode()
  {
    int result = x;
    result = 31 * result + y;
    return result;
  }

  @Override
  public String toString()
  {
    return "PointDemo{" +
      "first=" + x +
      ", second=" + y +
      '}';
  }
}

class LineDemo
{
  public PointDemo start, end;

  public LineDemo(PointDemo start, PointDemo end)
  {
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LineDemo LineDemo = (LineDemo) o;

    if (!start.equals(LineDemo.start)) return false;
    return end.equals(LineDemo.end);
  }

  @Override
  public int hashCode()
  {
    int result = start.hashCode();
    result = 31 * result + end.hashCode();
    return result;
  }
}

class VectorObjectDemo extends ArrayList<LineDemo> {}

class VectorRectangleDemo extends VectorObjectDemo
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public VectorRectangleDemo(int x, int y, int width, int height)
  {
    add(new LineDemo(new PointDemo(x,y), new PointDemo(x+width, y) ));
    add(new LineDemo(new PointDemo(x+width,y), new PointDemo(x+width, y+height) ));
    add(new LineDemo(new PointDemo(x,y), new PointDemo(x, y+height) ));
    add(new LineDemo(new PointDemo(x,y+height), new PointDemo(x+width, y+height) ));
  }
}

class LineDemoToPointDemoAdapter implements Iterable<PointDemo>
{
  private static int count = 0;
  private static Map<Integer, List<PointDemo>> cache = new HashMap<>();
  private int hash;

  public LineDemoToPointDemoAdapter(LineDemo LineDemo)
  {
    hash = LineDemo.hashCode();
    if (cache.get(hash) != null) return; // we already have it

    System.out.println(
      String.format("%d: Generating PointDemos for LineDemo [%d,%d]-[%d,%d] (no caching)",
        ++count, LineDemo.start.x, LineDemo.start.y, LineDemo.end.x, LineDemo.end.y));

    ArrayList<PointDemo> PointDemos = new ArrayList<>();

    int left = Math.min(LineDemo.start.x, LineDemo.end.x);
    int right = Math.max(LineDemo.start.x, LineDemo.end.x);
    int top = Math.min(LineDemo.start.y, LineDemo.end.y);
    int bottom = Math.max(LineDemo.start.y, LineDemo.end.y);
    int dx = right - left;
    int dy = LineDemo.end.y - LineDemo.start.y;

    if (dx == 0)
    {
      for (int y = top; y <= bottom; ++y)
      {
        PointDemos.add(new PointDemo(left, y));
      }
    }
    else if (dy == 0)
    {
      for (int x = left; x <= right; ++x)
      {
        PointDemos.add(new PointDemo(x, top));
      }
    }

    cache.put(hash, PointDemos);
  }

  @Override
  public Iterator<PointDemo> iterator()
  {
    return cache.get(hash).iterator();
  }

  @Override
  public void forEach(Consumer<? super PointDemo> action)
  {
    cache.get(hash).forEach(action);
  }

  @Override
  public Spliterator<PointDemo> spliterator()
  {
    return cache.get(hash).spliterator();
  }
}

class AdapterDemoWithCaching
{
  private static final List<VectorObjectDemo> vectorObjects =
    new ArrayList<>(Arrays.asList(
      new VectorRectangleDemo(1,1,10,10),
      new VectorRectangleDemo(3,3,6,6)
    ));

  public static void drawPointDemo(PointDemo p)
  {
    System.out.print(".");
  }

  private static void draw()
  {
    for (VectorObjectDemo vo : vectorObjects)
    {
      for (LineDemo LineDemo : vo)
      {
        LineDemoToPointDemoAdapter adapter = new LineDemoToPointDemoAdapter(LineDemo);
        adapter.forEach(PointDemo -> drawPointDemo(PointDemo));
      }
    }
  }

  public static void main(String[] args)
  {
    draw();
    draw();
  }
}