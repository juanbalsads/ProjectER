<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />


<xsl:template match="/">
 <html>
   <head><title>patient</title></head>
   <body>
   <h2>PATIENT</h2>
   <p><b>General information: </b></p>
   <table border="1">
    <tr>
      <th>name</th>
      <th>ssn</th>
      <th>weight</th>
      <th>height</th>
      <th>genre</th>
      <th>blood type</th>
      <th>date of birth</th>
    </tr>
    <xsl:for-each select="Patient">
    <tr>
     <td><xsl:value-of select="@name"/></td>
     <td><xsl:value-of select="@ssn"/></td>
     <td><xsl:value-of select="weight"/></td>
     <td><xsl:value-of select="height"/></td>
     <td><xsl:value-of select="genre"/></td>
     <td><xsl:value-of select="bloodType"/></td>
     <td><xsl:value-of select="dob"/></td>
    </tr>
    </xsl:for-each>
   </table>
   </body>
 </html>
</xsl:template>
</xsl:stylesheet>