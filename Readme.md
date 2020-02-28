# Spring Boot相关知识点梳理

通过一个简单服务的配置，整理下Spring Boot相关知识点。

## yml配置

application.yml

## mysql + mybatis

## redis

## log4j2配置

log4j2官网

https://logging.apache.org/log4j/2.x/

Spring Boot配置参考

https://www.cnblogs.com/keeya/p/10101547.html


## 构建包

通过maven-antrun-plugin插件，完成打包动作。
如下：
```xml
	<build>
		<plugins>
			<plugin>
				<artifactId>maven-antrun-plugin</artifactId>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<target>
								<copy todir="${project.basedir}/tools/run-dir" overwrite="true" >
									<fileset dir="${project.basedir}/target" erroronmissingdir="true">
										<include name="*.jar"/>
									</fileset>
									<fileset dir="${project.basedir}/target/classes" erroronmissingdir="true">
										<include name="*.yml"/>
									</fileset>
								</copy>
							</target>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```

## 待整理

- nginx代理

- 前台