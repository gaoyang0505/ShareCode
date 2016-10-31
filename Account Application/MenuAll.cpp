// MenuAll.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"

#include "Cassiopeia_313751158Doc.h"
#include "Cassiopeia_313751158View.h"

#include "MenuAll.h"
#include "MainFrm.h"

#include "PassWord.h"


#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMenuAll dialog


CMenuAll::CMenuAll(CWnd* pParent /*=NULL*/)
	: CDialog(CMenuAll::IDD, pParent)
{
	//{{AFX_DATA_INIT(CMenuAll)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
}


void CMenuAll::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CMenuAll)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CMenuAll, CDialog)
	//{{AFX_MSG_MAP(CMenuAll)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_BN_CLICKED(IDC_BUTTON2, OnButton2)
	ON_BN_CLICKED(IDC_BUTTON3, OnButton3)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMenuAll message handlers

void CMenuAll::OnOK() 
{
	// TODO: Add extra validation here

	CMenuAll::OnCancel();
	CMainFrame *pMain=(CMainFrame *)AfxGetApp()->m_pMainWnd;
	pMain->SwitchToForm(IDD_FORMVIEW_Statistics);
}

void CMenuAll::OnButton1() 
{
	// TODO: Add your control notification handler code here
	CMenuAll::OnCancel();
	CMainFrame *pMain=(CMainFrame *)AfxGetApp()->m_pMainWnd;
	pMain->SwitchToForm(IDD_CASSIOPEIA_313751158_FORM);
}

void CMenuAll::OnButton2() 
{
	// TODO: Add your control notification handler code here
	CMenuAll::OnCancel();
	CMainFrame *pMain=(CMainFrame *)AfxGetApp()->m_pMainWnd;
	pMain->SwitchToForm(IDD_FORMVIEW_Detail);
}

void CMenuAll::OnButton3() 
{
	// TODO: Add your control notification handler code here
	CPassWord dlg;
	dlg.DoModal();
}
