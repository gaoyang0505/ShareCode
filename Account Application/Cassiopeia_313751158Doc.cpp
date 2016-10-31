// Cassiopeia_313751158Doc.cpp : implementation of the CCassiopeia_313751158Doc class
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"

#include "Cassiopeia_313751158Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158Doc

IMPLEMENT_DYNCREATE(CCassiopeia_313751158Doc, CDocument)

BEGIN_MESSAGE_MAP(CCassiopeia_313751158Doc, CDocument)
	//{{AFX_MSG_MAP(CCassiopeia_313751158Doc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158Doc construction/destruction

CCassiopeia_313751158Doc::CCassiopeia_313751158Doc()
{
	// TODO: add one-time construction code here

}

CCassiopeia_313751158Doc::~CCassiopeia_313751158Doc()
{
}

BOOL CCassiopeia_313751158Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;
	    m_vctContent.clear();

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158Doc serialization

void CCassiopeia_313751158Doc::Serialize(CArchive& ar)
{
if (ar.IsStoring())
	{
		vector<CString>::iterator iter;
		for (iter = m_vctContent.begin();iter != m_vctContent.end(); iter++)
		{
			CString strtmp = *iter;
			ar.WriteString(strtmp);
		}

	}
	else
	{
		
	}
}

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158Doc diagnostics

#ifdef _DEBUG
void CCassiopeia_313751158Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CCassiopeia_313751158Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CCassiopeia_313751158Doc commands
