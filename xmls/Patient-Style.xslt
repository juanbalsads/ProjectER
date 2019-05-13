<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />
<xsl:template match="/">
   <html> 
   <p><b>__________________________PATIENTS__________________________ </b></p>
   <table border="1">
      <th><b>SSN</b></th>
      <th>Name</th>
      <th>Weight</th>
      <th>Height</th>
      <th>Genre</th>
      <th>Date of Birth</th>
      <th>Blood Type</th>
      <th>Admission</th>
      <xsl:for-each select="projectER/Patient">
      <xsl:sort select="@Name" />
         <xsl:if test="ssn &gt; 0">
            <tr>
            <td><i><xsl:value-of select="@ssn" /></i></td>
            <td><xsl:value-of select="@name" /></td>
            <td><xsl:value-of select="@weight" /></td>
            <td><xsl:value-of select="@height" /></td>
            <td><xsl:value-of select="@genre" /></td>
            <td><xsl:value-of select="@dob" /></td>
            <td><xsl:value-of select="@blood_type" /></td>
            </tr>
         </xsl:if>
      </xsl:for-each>
   </table>
   </html>
</xsl:template>

</xsl:stylesheet>