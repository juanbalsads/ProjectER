<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:template match="/">
   <html>
   <p><b>Patient</b></p>
   <p><b>Name: </b><xsl:value-of select="//name" /></p>
   <p><b>Information:</b></p>
   <table border="1">
      <th>weight</th>
      <th>height</th>
      <th>gender</th>
      <th>blood type</th>
      <th>date of birth</th>
      <xsl:for-each select="//name">
      <xsl:sort select="@name" />
            <tr>
            <td><xsl:value-of select="//weight" /></td>
            <td><xsl:value-of select="//height" /></td>
            <td><xsl:value-of select="//genre" /></td>
            <td><xsl:value-of select="//bloodType" /></td>
            <td><xsl:value-of select="//dob" /></td>
            </tr>
      </xsl:for-each>
   </table>
   
   <p><b>Admission:</b></p>
   <table border="1">
      <th>id</th>
      <th>arrival time</th>
      <xsl:for-each select="//admission">
            <tr>
            <td><xsl:value-of select="@id" /></td>
            <td><xsl:value-of select="//arrivalTime" /></td>
            <td><xsl:value-of select="//tests" /></td>
            <td><xsl:value-of select="//release" /></td>
            </tr>
      </xsl:for-each>
   </table>
   </html>
</xsl:template>

</xsl:stylesheet>