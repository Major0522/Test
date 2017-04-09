package application.range;

public class Test {

	private static final double EARTH_RADIUS = 6378.137;// 赤道半径(单位km)
	// private static final double EARTH_RADIUS = 6371.004;//地球平均半径(单位km)

	private static double longitude = 113.949352;
	private static double latitude = 22.539185;

	/**
	 * 地球上任意两点距离计算公式为 ： D＝R* arccos(siny1siny2+cosy1cosy2cos(x1-x2) )
	 * 其中:R为地球半径，均值为6370km. A点经、纬度分别为x1和y1,，东经为正，西经为负 B点经、纬度分别为x2和y2，北纬为正，南纬为负
	 * 注意的是经纬度是角度，算sin,cos值时先将其换算成弧度
	 */

	public static void main(String[] args) {
		
		double x1 = 114.116111;
		double y1 = 22.538282;
		
		double d = calDistance(longitude, latitude, x1, y1);
		
		double[] range = calRange(d, longitude, latitude);

		System.out.println("距离：" + d + "; 坐标范围，经度：" + range[0] + "，维度：" + range[1]);
	}

	/**
	 * 计算地球表面任意两点A（x1，y1）和B（x2，y2）之间的距离 <br>
	 * 计算公式：<code>L =R*ACos(Sin(y1)*Sin(y2)+Cos(y1)*Cos(y2)*Cos(x1-x2))</code>
	 * @param lng1 位置1的经度
	 * @param lat1 位置1的维度
	 * @param lng2 位置2的经度
	 * @param lat2 位置2的维度
	 * @return 距离
	 */
	public static double calDistance(double lng1, double lat1, double lng2, double lat2) {
		double s = EARTH_RADIUS * Math.acos(Math.sin(radian(lat1)) * Math.sin(radian(lat2))
				+ Math.cos(radian(lat1)) * Math.cos(radian(lat2)) * Math.cos(radian(lng1) - radian(lng2)));
		return s;
	}
	
	/**
	 * 根据当前位置计算已知距离的坐标范围<br>
	 * 计算公式：<code>经度 =ACos((Cos(L/R)-Sin(lat)*Sin(lat))/(Cos(lat)*Cos(lat)))+lng</code><br>
	 * 计算公式：<code>维度 =ASin(Cos(L/R))-lat</code>
	 * @param distance 已知距离
	 * @param lng 经度
	 * @param lat 维度
	 * @return 范围数组：[经度，纬度]
	 */
	public static double[] calRange(double distance, double lng, double lat){
		double lng1 = lng - Math.acos((Math.cos(distance / EARTH_RADIUS) - Math.sin(lat) * Math.sin(lat)) / (Math.cos(lat) * Math.cos(lat))) * 180.0 / Math.PI;
		double lat1 = Math.abs(distance / EARTH_RADIUS * 180.0 / Math.PI - lat);
		
		return new double[]{Math.abs(lng - lng1), Math.abs(lat - lat1)};
	}

	/**
	 * 转化为弧度(radian)
	 */
	private static double radian(double d) {
		return d * Math.PI / 180.0;
	}
}