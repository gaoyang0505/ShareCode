<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<title>Frameset Example Title (Replace this section with your
	own title)</title>
</head>


<frameset rows="80,*" frameborder="0" border="0" framespacing="0">
	<frame name="topNav" src="top_nav.htm">
	
	<frameset cols="200,*" frameborder="0" border="0" framespacing="0">
		<frame name="menu" src="menu_agent.htm" marginheight="0" marginwidth="0" scrolling="auto" noresize>
		<frame name="content" src="content.htm" marginheight="0" marginwidth="0" scrolling="auto" noresize>

		<noframes>
			<p>This section (everything between the 'noframes' tags) will
				only be displayed if the users' browser doesn't support frames. You
				can provide a link to a non-frames version of the website here. Feel
				free to use HTML tags within this section.</p>
		</noframes>

	</frameset>
</frameset>
</html>